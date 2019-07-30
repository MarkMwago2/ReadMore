package com.example.readmore;

public class Books {
    private String Title;
    private String Author;
    private int id;


    public Books(String title, String author, int id) {
        Title = title;
        Author = author;
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public int getId() {
        return id;
    }


    }


