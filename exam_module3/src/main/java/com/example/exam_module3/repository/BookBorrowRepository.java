package com.example.exam_module3.repository;

import com.example.exam_module3.model.BookBorrow;
import com.example.exam_module3.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookBorrowRepository implements IBookBorrowRepository {
    private final String SELECT_ALL_BOOK_CARD = "SELECT * FROM book_card";
    Connection conn = BaseRepository.getConnection();
    @Override
    public List<BookBorrow> findAll() {
        List<BookBorrow> bookBorrows = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_BOOK_CARD);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int bookCardId = resultSet.getInt("book_card_id");
                String borrowCode = resultSet.getString("borrow_code");
                int bookId = resultSet.getInt("book_id");
                int studentId = resultSet.getInt("student_id");
                String status = resultSet.getString("status");
                Timestamp borrowDate = resultSet.getTimestamp("borrow");
                Timestamp returnDate = resultSet.getTimestamp("return_date");
                BookBorrow bookBorrow = new BookBorrow(bookCardId, borrowCode, bookId, studentId,
                        status, borrowDate, returnDate);
                bookBorrows.add(bookBorrow);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookBorrows;
    }

}
