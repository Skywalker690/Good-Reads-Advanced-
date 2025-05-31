package com.example.goodreads.demo.service;

import com.example.goodreads.demo.model.Author;
import com.example.goodreads.demo.model.Book;
import com.example.goodreads.demo.model.Publisher;
import com.example.goodreads.demo.repository.AuthorJpaRepository;
import com.example.goodreads.demo.repository.BookJpaRepository;
import com.example.goodreads.demo.repository.PublisherJpaRepository;
import com.example.goodreads.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BookJpaService implements BookRepository {

    @Autowired
    private BookJpaRepository bookJpaRepository;

    @Autowired
    private PublisherJpaRepository publisherJpaRepository;

    @Autowired
    private AuthorJpaRepository authorJpaRepository;

    @Override
    public ArrayList<Book> getBooks() {
        List<Book> bookList = bookJpaRepository.findAll();
        return new ArrayList<>(bookList);
    }

    @Override
    public Book getBookById(int bookId) {
        try {
            return bookJpaRepository.findById(bookId).get();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Book addBook(Book book) {

        List<Integer> authorsIds = new ArrayList<>();
        for (Author author : book.getAuthor()){
            authorsIds.add(author.getAuthorId());
        }

        Publisher publisher = book.getPublisher();
        int publisherId = publisher.getPublisherId();

        try{

            List<Author> complete_authors =authorJpaRepository.findAllById(authorsIds);
            if(authorsIds.size() != complete_authors.size()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"One or more of the author ids are invalid ");
            }
            book.setAuthor(complete_authors);

            publisher = publisherJpaRepository.findById(publisherId).get();
            book.setPublisher(publisher);
            bookJpaRepository.save(book);
            return book;
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong publisherId");
        }
    }

    @Override
    public Book updateBook(int bookId, Book book) {

        try {
            Book newBook = bookJpaRepository.findById(bookId).get();
            if (book.getName() != null) {
                newBook.setName(book.getName());
            }
            if (book.getImageUrl() != null) {
                newBook.setImageUrl(book.getImageUrl());
            }
            if (book.getPublisher() != null) {
                Publisher publisher = book.getPublisher();
                int publisherId = publisher.getPublisherId();
                Publisher newPublisher = publisherJpaRepository.findById(publisherId).get();
                newBook.setPublisher(newPublisher);
            }
            bookJpaRepository.save(newBook);
            return newBook;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteBook(int bookId) {
        try {
            bookJpaRepository.deleteById(bookId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }


    @Override
    public Publisher getBookPublisher(int bookId) {
        try {
            Book book = bookJpaRepository.findById(bookId).get();
            return book.getPublisher();
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Author> getAuthors(int bookId) {
        Book book= bookJpaRepository.findById(bookId).get();
        return book.getAuthor();
    }
}