package com.example.exam_module3.service;

import com.example.exam_module3.model.Book;
import com.example.exam_module3.repository.BookRepository;
import com.example.exam_module3.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService {
        private IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int bookId) {
        return bookRepository.findById(bookId);
    }
}
