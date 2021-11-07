package com.example.learningmanagementsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningManagementSystemApplication {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
   }

    public static void main(String[] args) {
        SpringApplication.run(LearningManagementSystemApplication.class, args);
    }

}
