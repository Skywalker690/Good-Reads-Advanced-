package com.example.goodreads.demo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "author")
public class Author {

    @Id
    @Column(name = "authorid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authorId;

    @Column(name = "authorname")
    private String authorName;

    public Author(){

    }
    public Author(int authorid, String authorName){
        this.authorId = authorid;
        this.authorName = authorName;
    }

    public int getAuthorId(){
        return authorId;
    }
    public void setAuthorIdId(int authorId){
        this.authorId = authorId;
    }

    public String getAuthorName(){
        return authorName;
    }
    public void setAuthorName(String authorName){
        this.authorName = authorName;
    }

}