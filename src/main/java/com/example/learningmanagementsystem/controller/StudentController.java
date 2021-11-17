package com.example.learningmanagementsystem.controller;

import com.example.learningmanagementsystem.entity.Student;
import com.example.learningmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student){

        return studentService.createStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.findByStudentId(id);
    }

    @PutMapping("/{username}/enroll")
    public String enrollStudentForCourse(@PathVariable("username") String username, @RequestParam Long courseId){

        Student student = studentService.findStudentByUsername(username);
        studentService.enroll(student.getStudentId(), courseId);

        return "You have unEnrolled for courseId"+ courseId;
    }

    @PutMapping("/{username}/unenroll")
    public String unEnrollStudentForCourse(@PathVariable("username") String username, @RequestParam Long courseId){
        Student student = studentService.findStudentByUsername(username);
        studentService.unEnroll(student.getStudentId(), courseId);

        return "You have unEnrolled for courseId"+ courseId;
    }
}
