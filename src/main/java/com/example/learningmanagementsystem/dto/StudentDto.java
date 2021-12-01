package com.example.learningmanagementsystem.dto;

import com.example.learningmanagementsystem.entity.Gender;
import lombok.Data;

@Data
public class StudentDto {


    private String firstName;
    private String lastName;
    private Gender gender;
}
