package com.example.learningmanagementsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(nullable = false)
    private String courseTitle;
    @CreationTimestamp
    private LocalDate dateCreated;
    private LocalDate datePublished;
    @UpdateTimestamp
    private LocalDate updatedAt;
    private boolean isPublished;
    private String duration;
    @Column(length = 1000)
    private String description;
    @ElementCollection
    private List<String> imageUrls;

    private String language;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Instructor instructor;
    @ManyToMany
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {

        for(Student studentRef: students){
            if(student.getStudentId().equals(studentRef.getStudentId())){
                return;
            }
        }
        students.add(student);
    }
}
