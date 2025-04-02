package com.example.exam_module3.repository;

import com.example.exam_module3.model.BookBorrow;

import java.util.List;

public interface IBookBorrowRepository {
    List<BookBorrow> findAll();
}
