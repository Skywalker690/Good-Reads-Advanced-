package com.example.goodreads.demo.repository;


import com.example.goodreads.demo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AuthorJpaRepository extends JpaRepository<Author,Integer> {
}