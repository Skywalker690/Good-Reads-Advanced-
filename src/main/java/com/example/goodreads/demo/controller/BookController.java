package com.example.goodreads.demo.controller;

import com.example.goodreads.demo.model.Book;
import com.example.goodreads.demo.model.Publisher;
import com.example.goodreads.demo.service.BookJpaService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;


import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
class BookController {
    @Autowired
    public BookJpaService bookService;

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable("bookId") int bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping("/publishers/books")
    public Book addBook(@RequestBody Book book) {

        return bookService.addBook(book);
    }

    @PutMapping("/publishers/books/{bookId}")
    public Book updateBook(@PathVariable("bookId") int bookId, @RequestBody Book book) {
        return bookService.updateBook(bookId, book);
    }

    @DeleteMapping("/books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
        bookService.deleteBook(bookId);
    }

    @GetMapping("/books/{bookId}/publisher")
    public Publisher getBookPublisher(@PathVariable("bookId") int bookId) {
        return bookService.getBookPublisher(bookId);
    }
}