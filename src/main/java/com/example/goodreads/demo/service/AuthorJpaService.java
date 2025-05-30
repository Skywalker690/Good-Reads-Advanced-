package com.example.goodreads.demo.service;

import com.example.goodreads.demo.model.Author;
import com.example.goodreads.demo.repository.AuthorJpaRepository;
import com.example.goodreads.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorJpaService implements AuthorRepository {

    @Autowired
    private AuthorJpaRepository authorJpaRepository;

    @Override
    public ArrayList<Author> getAuthors() {
        List<Author> authorList = authorJpaRepository.findAll();
        return new ArrayList<>(authorList);
    }

    @Override
    public Author getAuthorById(int authorId) {
        try {
            return authorJpaRepository.findById(authorId).get();
        }catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Author addAuthor(Author author) {
        authorJpaRepository.save(author);
        return author;
    }

    @Override
    public Author updateAuthor(int authorId, Author author) {
        try{
            Author new_author = authorJpaRepository.findById(authorId).get();
            if(author.getAuthorName()!=null)new_author.setAuthorName(author.getAuthorName());
            authorJpaRepository.save(new_author);
            return new_author;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteAuthor(int authorId) {
        try {
            authorJpaRepository.deleteById(authorId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
}