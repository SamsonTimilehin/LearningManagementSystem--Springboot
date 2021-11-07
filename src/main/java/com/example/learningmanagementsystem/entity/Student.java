package com.example.learningmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LearningParty learningParty;
    @ManyToMany
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course) {

        for(Course course1: courses){
            if(course1.getCourseId().equals(course.getCourseId()))
                return;
        }
        courses.add(course);
    }
}
