package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import com.example.learningmanagementsystem.repository.CourseRepository;
import com.example.learningmanagementsystem.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
public class InstructorServiceImpl implements InstructorService{

    @Autowired
    private InstructorRepository instructorRepository;

    @Autowired
    private CourseService courseService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Instructor createInstructor(Instructor instructor) {

        return instructorRepository.save(instructor);
    }

    @Override
    public List<Instructor> getInstructors() {

        return instructorRepository.findAll();
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    public Instructor findByName(String instructorName) {
        return instructorRepository.findByLastName(instructorName);
    }

    @Override
    @Transactional
    public Course createCourse(CourseDto courseDto) {

        if(courseDto == null){
            throw new IllegalArgumentException("Course can't be null");
        }

        return courseService.saveCourse(courseDto);
    }

    @Override
    public Course updateCourse(Long courseId, CourseDto courseUpdate) {
        return courseService.updateCourse(courseId, courseUpdate);
    }

    @Override
    public void deleteCourseById(Long courseId, String instructorName) {
        Instructor instructor = instructorRepository.findByLastName(instructorName);
        Course course = courseService.findByCourseId(courseId);
        instructor.removeCourseById(course.getCourseId());
        courseService.deleteCourseById(course.getCourseId());

        instructorRepository.save(instructor);
    }

    @Override
    public List<Course> getCourses(String courseTitle) {

        return courseService.getCoursesByTitle(courseTitle);
    }

    @Override
    public Course publishCourse(Long id, String courseTitle) {
        Instructor instructorDB = instructorRepository.findById(id).get();
       Course courseToPublish =instructorDB.getCourses().stream()
                .filter(val -> val.getCourseTitle().equals(courseTitle)).findFirst().get();
        courseToPublish.setPublished(true);
        return courseToPublish;
    }

}
