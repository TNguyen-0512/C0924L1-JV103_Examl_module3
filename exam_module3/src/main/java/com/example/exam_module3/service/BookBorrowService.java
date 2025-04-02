package com.example.exam_module3.service;

import com.example.exam_module3.model.BookBorrow;
import com.example.exam_module3.repository.BookBorrowRepository;
import com.example.exam_module3.repository.IBookBorrowRepository;

import java.util.List;

public class BookBorrowService implements IBookBorrowService {
    private IBookBorrowRepository bookBorrowRepository = new BookBorrowRepository();
    @Override
    public List<BookBorrow> findAll() {
        return bookBorrowRepository.findAll();
    }

    @Override
    public BookBorrow findById(int bookId) {
        return null;
    }
}
