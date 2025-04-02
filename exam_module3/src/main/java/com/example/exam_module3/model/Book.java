package com.example.exam_module3.model;

public class Book {
    private int id;
    private String name;
    private String author;
    private String description;
    private int stock;

    public Book() {
    }

    public Book(int id, String name, String author, String description, int stock) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.description = description;
        this.stock = stock;
    }

    public Book(int id, String name, String author, int stock, String description) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
