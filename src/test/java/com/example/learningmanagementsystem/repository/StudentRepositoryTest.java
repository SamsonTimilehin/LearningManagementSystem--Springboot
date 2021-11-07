package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){

        Student student1 = Student.builder()
                .firstName("Segun")
                .lastName("Adeola")
                .build();
        studentRepository.save(student1);
    }
}