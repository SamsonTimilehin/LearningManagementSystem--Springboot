package com.example.learningmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Email {
    private String recipient;
    private String mailBody;
    public static final String SUBJECT = "E-Learning account activation";
}
