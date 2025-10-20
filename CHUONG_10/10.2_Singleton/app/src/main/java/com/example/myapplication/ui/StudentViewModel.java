package com.example.myapplication.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.Callback;
import com.example.myapplication.data.RemoteDataSource;
import com.example.myapplication.data.model.Student;
import com.example.myapplication.data.model.StudentList;

import java.util.List;

public class StudentViewModel extends ViewModel {
    private final MutableLiveData<List<Student>> mStudents = new MutableLiveData<>();
    private final MutableLiveData<String> mErrorMessage = new MutableLiveData<>();
    public LiveData<List<Student>> getStudents() {
        return mStudents;
    }
    public LiveData<String> getErrorMessage() {
        return mErrorMessage;
    }
    public void loadStudents() {
        RemoteDataSource dataSource = RemoteDataSource.getInstance();
        Callback<StudentList> callback = new Callback<StudentList>() {
            @Override
            public void onSuccess(StudentList data) {
                if (data != null) {
                    mStudents.postValue(data.getStudents());
                    mErrorMessage.postValue(null);
                } else {
                    mStudents.postValue(null);
                    mErrorMessage.postValue("No students data");
                }
            }

            @Override
            public void onFailure(Exception e) {
                mStudents.postValue(null);
                mErrorMessage.postValue(e.getMessage());
            }
        };
        dataSource.loadStudents(callback);
    }
}
