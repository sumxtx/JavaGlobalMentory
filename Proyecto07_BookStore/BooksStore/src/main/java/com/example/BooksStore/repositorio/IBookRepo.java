package com.example.BooksStore.repositorio;

import com.example.BooksStore.modelo.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepo extends JpaRepository<Book, Integer> {
}
