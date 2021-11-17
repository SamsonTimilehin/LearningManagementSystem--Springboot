package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import com.example.learningmanagementsystem.service.InstructorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/instructor")
@Slf4j
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor){
        return instructorService.createInstructor(instructor);
    }

    @GetMapping
    public List<Instructor> getInstructors(){
        return instructorService.getInstructors();
    }

    @GetMapping("/{id}")
    public Instructor findInstructorById(@PathVariable("id") Long id){
        return instructorService.findInstructorById(id);
    }

    @GetMapping("/name/{instructorName}")
    public Instructor findInstructorByName(@PathVariable String instructorName){
        return instructorService.findByName(instructorName);
    }

    @PostMapping("/createCourse")
    public Course createCourse(@RequestBody CourseDto courseDto){

      return instructorService.createCourse(courseDto);
    }
    @PostMapping("/publishCourse/{id}")
   public Course publishCourse(@PathVariable Long id, @RequestBody String courseTitle){
        return instructorService.publishCourse(id,courseTitle);
   }
}
