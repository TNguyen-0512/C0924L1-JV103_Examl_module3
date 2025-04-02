package com.example.exam_module3.service;

import com.example.exam_module3.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    Book findById(int bookId);
}
