package com.example.goodreads.demo.controller;

import com.example.goodreads.demo.model.Author;
import com.example.goodreads.demo.service.AuthorJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class AuthorController {

    @Autowired
    private AuthorJpaService authorJpaService;

    @GetMapping("/authors")
    public ArrayList<Author> getAuthors(){
        return authorJpaService.getAuthors();
    }

    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") int id){
        return authorJpaService.getAuthorById(id);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author){
        return authorJpaService.addAuthor(author);
    }

    @PutMapping("/authors/{id}")
    public Author updateAuthor(@RequestBody Author author, @PathVariable("id") int id) {
        return authorJpaService.updateAuthor(id, author);
    }

    @DeleteMapping("/authors/{id}")
    public void deleteAuthor(@PathVariable("id") int id) {
        authorJpaService.deleteAuthor(id);
    }
}