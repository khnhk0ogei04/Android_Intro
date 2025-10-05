package com.example.myapplication.data.source;

import com.example.myapplication.data.model.Student;

import java.util.List;

public interface StudentDataSource {
    List<Student> loadData();
}

