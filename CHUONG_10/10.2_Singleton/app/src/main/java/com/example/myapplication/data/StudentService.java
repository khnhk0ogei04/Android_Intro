package com.example.myapplication.data;

import com.example.myapplication.data.model.StudentList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StudentService {
    @GET("/resources/braniumapis/student.json")
    Call<StudentList> getStudents();
}
