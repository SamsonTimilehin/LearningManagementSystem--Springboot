package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Student;
import com.example.learningmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseService courseService;

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student findByStudentId(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid student id"));
    }

    @Override
    public void enroll(Long studentId, Long courseId) {

        Student student = findByStudentId(studentId);

        Course course = courseService.findByCourseId(courseId);

        student.addCourse(course);
        course.addStudent(student);

        studentRepository.save(student);
    }

    @Override
    public void unEnroll(Long studentId, Long courseId) {
        Student student = findByStudentId(studentId);

        Course course = courseService.findByCourseId(courseId);

        student.getCourses().removeIf(course1 -> course1.getCourseId().equals(courseId));
        course.getStudents().removeIf(student1 -> student1.getStudentId().equals(studentId));

        studentRepository.save(student);
    }

    @Override
    public Student findStudentByUsername(String username) {
        return studentRepository.findByFirstName(username);
    }
}
