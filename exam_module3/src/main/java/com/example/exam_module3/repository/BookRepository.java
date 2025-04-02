package com.example.exam_module3.repository;

import com.example.exam_module3.model.Book;
import com.example.exam_module3.util.BaseRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private static final String SELECT_ALL = "SELECT * FROM book";
    String FIND_BY_ID = "SELECT * FROM book WHERE book_id = ?";
    private Connection conn = BaseRepository.getConnection();

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        // Kiểm tra kết nối
        if (conn == null) {
            System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
            return books;
        }

        try (PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("book_id");
                String name = resultSet.getString("book_name");
                String author = resultSet.getString("author");
                int stock = resultSet.getInt("stock");
                String description = resultSet.getString("description");

                Book book = new Book(id, name, author, description, stock);
                books.add(book);
            }
            // Dùng logging thay vì System.out.println
            System.out.println("Danh sách sách lấy được: " + books); // Có thể thay bằng Logger

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    @Override
    public Book findById(int id) {
        try (PreparedStatement stmt = conn.prepareStatement(FIND_BY_ID)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("book_name");
                    String author = rs.getString("author");
                    int stock = rs.getInt("stock");
                    String description = rs.getString("description");
                    return new Book(id, name, author, description, stock);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
