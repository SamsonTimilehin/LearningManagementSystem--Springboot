package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Set;


@SpringBootTest
class InstructorRepositoryTest {

    @Autowired
    private InstructorRepository instructorRepository;

    @Test
    public void saveInstructor(){
        Course course101 = Course.builder()
                .courseTitle("Kotlin")
                //.courseUnit(2)
                .build();

        Course biz102 = Course.builder()
                .courseTitle("Html")
                //.courseUnit(3)
                .build();

        Instructor instructor = Instructor.builder()
                .firstName("Mofe")
                .lastName("Tunde")
                .courses(List.of(course101,biz102))
                .build();
        instructorRepository.save(instructor);
    }

}