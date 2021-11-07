package com.example.learningmanagementsystem.dto;

import lombok.Data;

@Data
public class CourseDto {

    private String instructorName;
    private String courseTitle;
    private String description;
    private String duration;
    private String language;
    private boolean isPublished;
}
