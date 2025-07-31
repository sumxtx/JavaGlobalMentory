package com.example.BooksStore.view;

import com.example.BooksStore.modelo.Book;
import com.example.BooksStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Component
public class BookForm extends JFrame {
    BookService bookService;
    private JPanel mainPanel;
    private JTable bookTable;
    private JTextField idHiddenText;
    private JTextField bookText;
    private JTextField authorText;
    private JTextField priceText;
    private JTextField existencesText;
    private JButton addButton;
    private JButton modifyButton;
    private JButton removeButton;
    private DefaultTableModel bookTableModel;


    @Autowired
    public BookForm(BookService bookService){
        this.bookService = bookService;
        initForm();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addBook();
            }
        });
        bookTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                loadSelectedBook();
            }
        });
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                modifyBook();
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                removeBook();
            }
        });
    }

    private void addBook(){
        if(bookText.getText().equals("")){
            showMessage("Insert Book Name");
            bookText.requestFocusInWindow();
            return;
        }
        var bookName = bookText.getText();
        var author = authorText.getText();
        var price = Double.parseDouble(priceText.getText());
        var existences = Integer.parseInt(existencesText.getText());
        var book = new Book();
        book.setBookName(bookName);
        book.setAuthor(author);
        book.setPrice(price);
        book.setExistences(existences);
        this.bookService.saveBook(book);
        showMessage("The Book Has Been Added");
        cleanForm();
        listBooks();
    }

    private void loadSelectedBook(){
        var holder = bookTable.getSelectedRow();
        if(holder != -1){
            String bookId = bookTable.getModel().getValueAt(holder, 0).toString();
            idHiddenText.setText(bookId);
            String bookName = bookTable.getModel().getValueAt(holder,1).toString();
            bookText.setText(bookName);
            String author = bookTable.getModel().getValueAt(holder, 2).toString();
            authorText.setText(author);
            String price = bookTable.getModel().getValueAt(holder, 3).toString();
            priceText.setText(price);
            String existences = bookTable.getModel().getValueAt(holder, 4).toString();
            existencesText.setText(existences);
        }
    }

    private void modifyBook(){
        if(this.idHiddenText.getText().equals("")){
            showMessage("Select one register");
        }
        else{
            if(bookText.getText().equals("")){
                showMessage("Insert Book Name");
                bookText.requestFocusInWindow();
                return;
            }
            int bookId = Integer.parseInt(idHiddenText.getText());
            var bookName = bookText.getText();
            var author = authorText.getText();
            var price = Double.parseDouble(priceText.getText());
            var existences = Integer.parseInt(existencesText.getText());
            var book = new Book(bookId, bookName, author, price, existences);
            bookService.saveBook(book);
            showMessage("Book Has Been Modified");
            cleanForm();
            listBooks();
        }
    }

    private void removeBook(){
        var holder = bookTable.getSelectedRow();
        if(holder != -1){
            String bookId = bookTable.getModel().getValueAt(holder, 0).toString();
            var book = new Book();
            book.setIdBook(Integer.parseInt(bookId));
            bookService.deleteBook(book);
            showMessage("Book Has Been Deleted");
            cleanForm();
            listBooks();
        }
        else {
            showMessage("Select a Book To Delete");
        }
    }

    private void showMessage(String Message){
        JOptionPane.showMessageDialog(this, Message);
    }

    private void cleanForm() {
        bookText.setText("");
        authorText.setText("");
        priceText.setText("");
        existencesText.setText("");
    }
    private void initForm() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,700);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - getWidth() / 2);
        int y = (screenSize.height = getHeight() / 2);
        setLocation(x, y);
    }

    private void createUIComponents() {
        idHiddenText = new JTextField("");
        idHiddenText.setVisible(false);

        // TODO: place custom component creation code here
        this.bookTableModel = new DefaultTableModel(0, 5);
        String[] headers = {"Id", "Book", "Author", "Price", "Existences"};
        this.bookTableModel.setColumnIdentifiers(headers);
        this.bookTable = new JTable(bookTableModel);
        listBooks();
    }
    private void listBooks(){
        bookTableModel.setRowCount(0);

        var books = bookService.listBooks();
        books.forEach((book)-> {
            Object[] renglonBook = {
                    book.getIdBook(),
                    book.getBookName(),
                    book.getAuthor(),
                    book.getPrice(),
                    book.getExistences()
            };
            this.bookTableModel.addRow(renglonBook);
        });
    }
}
