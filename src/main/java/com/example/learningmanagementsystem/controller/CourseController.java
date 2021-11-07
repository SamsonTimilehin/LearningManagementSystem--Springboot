package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.service.CourseService;
import com.example.learningmanagementsystem.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public Course createCourse(@RequestBody CourseDto courseDto){

        return instructorService.createCourse(courseDto);
    }

    @PutMapping("/{courseId}")
    public Course updateCourseDetails(@PathVariable("courseId") Long courseId, @RequestBody CourseDto courseDto){
        return instructorService.updateCourse(courseId, courseDto);
    }

    @DeleteMapping("/{courseId}")
    public String deleteCourseById(@PathVariable("courseId") Long courseId){
        instructorService.deleteCourseById(courseId);
        return "Course with id" + courseId + " is successfully deleted";
    }
}
