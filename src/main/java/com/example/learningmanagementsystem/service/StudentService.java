package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);

    List<Student> getAllStudents();


}