package com.example.actionbar.model;

public class Student {
    private String fullName;
    private int age;

    public Student() {}
    public Student(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }
}
