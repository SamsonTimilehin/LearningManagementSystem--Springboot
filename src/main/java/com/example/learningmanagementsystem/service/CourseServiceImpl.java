package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import com.example.learningmanagementsystem.repository.CourseRepository;
import com.example.learningmanagementsystem.repository.InstructorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService{

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private InstructorService instructorService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Course saveCourse(CourseDto courseDto) {

        if(courseDto == null){
            throw new IllegalArgumentException("Course Can't be null");
        }
        Instructor instructor = instructorService.findByName(courseDto.getInstructorName());
        Course course;
       course = modelMapper.map(courseDto,Course.class);

        course.setInstructor(instructor);
        instructor.addCourse(course);

        course = courseRepository.save(course);


        return course;
    }

    @Override
    public Course updateCourse(Long courseId, CourseDto courseUpdate) {
        Course courseDB = courseRepository.findById(courseId).orElse(null);
        if(courseDB == null){
            throw new IllegalArgumentException("courseId is null");
        }

        modelMapper.map(courseUpdate, courseDB);
        courseRepository.save(courseDB);



        return courseDB;
    }

    @Override
    public void deleteCourseById(Long courseId) {
         courseRepository.deleteById(courseId);
    }
}
