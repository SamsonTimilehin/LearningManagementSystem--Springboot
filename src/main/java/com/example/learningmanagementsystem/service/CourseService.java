package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;

import java.util.List;

public interface CourseService {

    Course saveCourse(CourseDto courseDto);

    Course updateCourse(Long courseId,CourseDto courseUpdate);

    void deleteCourseById(Long courseId, CourseDto courseDto);

    Course findByCourseId(Long courseId);

    void deleteCourseById(Long courseId);

    List<Course> getCoursesByTitle(String title);
}
