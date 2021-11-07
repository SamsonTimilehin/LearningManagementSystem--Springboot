package com.example.learningmanagementsystem.entity;

public enum Gender {
    MALE,FEMALE;

    @Override
    public String toString() {
        String value = " ";

        switch(this){
            case MALE:
                value = "male";
            break;
            case FEMALE:
                 value = "female";
                 break;
        }
        return value;
    }
}
