package com.example.exam_module3.service;

import com.example.exam_module3.model.Student;
import com.example.exam_module3.repository.StudentRepository;

import java.util.List;

public class StudentService implements IStudentService {
    private StudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
