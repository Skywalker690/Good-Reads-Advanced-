package com.example.goodreads.demo.repository;

import java.util.ArrayList;
import java.util.List;

import com.example.goodreads.demo.model.Author;
import com.example.goodreads.demo.model.Book;
import com.example.goodreads.demo.model.Publisher;

public interface BookRepository {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int bookId, Book book);

    void deleteBook(int bookId);

    Publisher getBookPublisher(int bookId);

    List<Author> getAuthors(int bookId);
}
