package com.example.learningmanagementsystem.repository;

import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;




@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void saveCourses(){


        Instructor instructor1 = Instructor.builder()
                .firstName("Mr Bolu")
                .lastName("Lanre")
                .build();

        Course course = Course.builder()
                .courseTitle("Social Studies")
                .description("Home management")
                .instructor(instructor1)
                .build();

        courseRepository.save(course);

    }

}