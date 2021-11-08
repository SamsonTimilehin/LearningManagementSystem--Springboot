package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;

import java.util.List;


public interface InstructorService {

    Instructor createInstructor(Instructor instructor);

    List<Instructor> getInstructors();

    Instructor findInstructorById(Long id);

    Instructor findByName(String instructorName);

    Course createCourse(CourseDto courseDto);

    Course updateCourse(Long courseId, CourseDto courseUpdate);

    void deleteCourseById(Long courseId, String instructorName);


}
