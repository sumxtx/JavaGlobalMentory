package com.example.BooksStore.service;

import com.example.BooksStore.modelo.Book;

import java.util.List;

public interface IBookService {
    public List<Book> listBooks();

    public Book findBookById(Integer idBook);

    public void saveBook(Book book);

    public void deleteBook(Book book);
}
