package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.dto.InstructorDTO;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import com.example.learningmanagementsystem.repository.CourseRepository;
import com.example.learningmanagementsystem.repository.InstructorRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
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
    public void deleteCourseById(Long courseId) {
        courseService.deleteCourseById(courseId);
    }

}