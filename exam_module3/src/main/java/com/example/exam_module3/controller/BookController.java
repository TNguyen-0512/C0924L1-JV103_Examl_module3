package com.example.exam_module3.controller;

import com.example.exam_module3.model.Book;
import com.example.exam_module3.model.BookBorrow;
import com.example.exam_module3.model.Student;
import com.example.exam_module3.service.BookService;
import com.example.exam_module3.service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="BookController", value = "/books")
public class BookController extends HttpServlet {
    private BookService bookService = new BookService();
    private StudentService studentService = new StudentService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                showBorrowForm(req, resp);
                break;
            default:
                showList(req, resp);
        }
    }

    private void showBorrowForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int bookId = Integer.parseInt(req.getParameter("bookId"));
        Book book = bookService.findById(bookId);
        List<Student> students = studentService.findAll();
        java.time.LocalDate today = java.time.LocalDate.now();
        String borrowDate = today.toString();
        String returnDate = today.plusDays(5).toString();
        req.setAttribute("book", book);
        req.setAttribute("students", students);
        req.setAttribute("borrowDate", borrowDate);
        req.setAttribute("returnDate", returnDate);
        req.getRequestDispatcher("/views/book/borrow_book.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "borrow":
                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> books = bookService.findAll();
        System.out.println("Books from Controller: " + books);
        req.setAttribute("books", books);
        req.getRequestDispatcher("/views/book/book_list.jsp").forward(req, resp);
    }
}

