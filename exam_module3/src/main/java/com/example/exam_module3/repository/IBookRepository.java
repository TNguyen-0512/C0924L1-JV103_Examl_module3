package com.example.exam_module3.repository;

import com.example.exam_module3.model.Book;

import java.util.List;

public interface IBookRepository {
    List<Book> findAll();
    Book findById(int id);
}
