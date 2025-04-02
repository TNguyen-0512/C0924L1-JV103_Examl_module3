package com.example.exam_module3.model;

import java.sql.Timestamp;
import java.time.LocalDate;

public class BookBorrow {
    private String id;
    private int bookId;
    private int studentId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private boolean isReturned;
    private String bookName;
    private String studentName;

    public BookBorrow(int bookCardId, String borrowCode, int bookId, int studentId, String status, Timestamp borrowDate, Timestamp returnDate) {
    }

    public BookBorrow(String id, int bookId, int studentId, LocalDate borrowDate, LocalDate returnDate) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = false;
    }

    public BookBorrow(String id, int bookId, int studentId, LocalDate borrowDate, LocalDate returnDate,
                      boolean isReturned, String bookName, String studentName) {
        this.id = id;
        this.bookId = bookId;
        this.studentId = studentId;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.isReturned = isReturned;
        this.bookName = bookName;
        this.studentName = studentName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}