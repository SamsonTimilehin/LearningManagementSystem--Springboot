package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;

public interface CourseService {

    Course saveCourse(CourseDto courseDto);

    Course updateCourse(Long courseId,CourseDto courseUpdate);

    void deleteCourseById(Long courseId);
}
