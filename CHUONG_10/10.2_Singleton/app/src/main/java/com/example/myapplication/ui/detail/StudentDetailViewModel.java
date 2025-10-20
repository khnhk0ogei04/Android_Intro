package com.example.myapplication.ui.detail;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.RemoteDataSource;
import com.example.myapplication.data.model.Student;

public class StudentDetailViewModel extends ViewModel {
    private final MutableLiveData<Student> mStudent = new MutableLiveData<>();

    public LiveData<Student> getStudent() {
        return mStudent;
    }

    public void loadStudent(String studentId) {
        RemoteDataSource dataSource = RemoteDataSource.getInstance();
        Student student = dataSource.getStudent(studentId);
        mStudent.setValue(student);
    }
}
