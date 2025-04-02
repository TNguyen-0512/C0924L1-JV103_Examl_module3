package com.example.exam_module3.repository;

import com.example.exam_module3.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
