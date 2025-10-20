package com.example.myapplication.data.model;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    private List<Student> mStudents = new ArrayList<>();

    public List<Student> getStudents(){
        return mStudents;
    }

    public void setStudents(List<Student> students){
        mStudents = students;
    }
}
