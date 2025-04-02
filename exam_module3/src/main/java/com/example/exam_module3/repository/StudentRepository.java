package com.example.exam_module3.repository;

import com.example.exam_module3.model.Student;
import com.example.exam_module3.util.BaseRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private final String SELECT_ALL_STUDENTS = "SELECT * FROM student";
    Connection conn = BaseRepository.getConnection();

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(SELECT_ALL_STUDENTS);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("student_id");
                String name = resultSet.getString("student_name");
                String className = resultSet.getString("class");
                Student student = new Student(id, name, className);
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
