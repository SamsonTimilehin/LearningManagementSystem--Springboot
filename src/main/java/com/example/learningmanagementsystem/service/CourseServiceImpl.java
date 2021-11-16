package com.example.learningmanagementsystem.service;

import com.example.learningmanagementsystem.dto.CourseDto;
import com.example.learningmanagementsystem.entity.Course;
import com.example.learningmanagementsystem.entity.Instructor;
import com.example.learningmanagementsystem.repository.CourseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

        if(courseUpdate.isPublished()){
            courseDB.setDatePublished(LocalDate.now());
        }

        return courseDB;
    }

    @Override
    public void deleteCourseById(Long courseId, CourseDto courseDto) {
         courseRepository.deleteById(courseId);
    }

    @Override
    public Course findByCourseId(Long courseId) {
        return courseRepository.findById(courseId).get();
    }

    @Override
    public void deleteCourseById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public List<Course> getCoursesByTitle(String courseTitle) {

       List<Course> courses = courseRepository.findAllByCourseTitle(courseTitle);

        return courses;
    }
}
