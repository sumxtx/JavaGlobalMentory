package com.example.BooksStore.service;

import com.example.BooksStore.modelo.Book;
import com.example.BooksStore.repositorio.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private IBookRepo bookRepo;

    @Override
    public List<Book> listBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book findBookById(Integer idBook) {
        Book book = bookRepo.findById(idBook).orElse(null);
        return book;
    }

    @Override
    public void saveBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    public void deleteBook(Book book) {
        bookRepo.delete(book);
    }
}
