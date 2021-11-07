package com.example.learningmanagementsystem.dto;


import lombok.Data;


@Data
public class InstructorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String gender;
    private String specialization;
    private String courseImageUrl;
    private String courseTitle;
    private String description;
    private String duration;
    private String bio;

}
