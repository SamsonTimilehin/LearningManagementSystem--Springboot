package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.StudentDto;
import com.example.learningmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(StudentDto studentDto);

    List<Student> getAllStudents();

    Student findByStudentId(Long id);

    void enroll(Long studentId, Long courseId);

    void unEnroll(Long studentId, Long courseId);

    Student findStudentByUsername(String username);
}
