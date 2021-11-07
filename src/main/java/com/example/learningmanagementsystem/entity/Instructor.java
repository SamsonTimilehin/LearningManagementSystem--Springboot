package com.example.learningmanagementsystem.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String specialization;
    @Column(length = 1000)
    private String bio;
    @OneToOne(cascade = CascadeType.PERSIST)
    private LearningParty learningParty;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
    }

    public void removeCourseById(Long id) {

        courses.removeIf(courseRef -> courseRef.getCourseId().equals(id) );
    }

}
