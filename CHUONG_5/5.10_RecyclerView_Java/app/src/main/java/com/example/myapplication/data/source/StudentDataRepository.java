package com.example.myapplication.data.source;

import com.example.myapplication.data.model.Student;

import java.util.List;

public class StudentDataRepository {
    private final StudentDataSource mDataSource;

    public StudentDataRepository(StudentDataSource dataSource) {
        mDataSource = dataSource;
    }

    public List<Student> loadData() {
        return mDataSource.loadData();
    }
}
