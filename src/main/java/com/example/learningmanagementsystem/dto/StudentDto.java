package com.example.learningmanagementsystem.dto;

import com.example.learningmanagementsystem.entity.Gender;
import lombok.Data;

@Data
public class StudentDto {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
//    private Integer yearOfBirth;
//    private Integer monthOfBirth;
//    private Integer dayOfBirth;
    private Gender gender;
}
