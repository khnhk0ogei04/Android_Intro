package com.example.actionbar.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.actionbar.model.Student;

public class StudentViewModel extends ViewModel {
    private final MutableLiveData<Student> liveData = new MutableLiveData<>();

    public StudentViewModel() {
        liveData.setValue(new Student("Nguyen Khanh", 20));
    }

    public LiveData<Student> getStudent() {
        return liveData;
    }

    public void setStudent(Student student){
        liveData.setValue(student);
    }
}
