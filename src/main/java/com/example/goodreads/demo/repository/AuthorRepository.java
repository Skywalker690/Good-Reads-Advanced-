package com.example.goodreads.demo.repository;

import com.example.goodreads.demo.model.Author;

import java.util.ArrayList;

public interface AuthorRepository {
    ArrayList<Author> getAuthors();

    Author getAuthorById(int authorId);

    Author addAuthor(Author author);

    Author updateAuthor(int authorId, Author author);

    void deleteAuthor(int authorId);
}
