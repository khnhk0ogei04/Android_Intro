package com.example.myapplication.data;

import com.example.myapplication.data.model.Student;
import com.example.myapplication.data.model.StudentList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import retrofit2.Call;
import retrofit2.Response;

public class RemoteDataSource {
    private final List<Student> mStudents = new ArrayList<>();
    private static volatile RemoteDataSource sInstance = null;
    private RemoteDataSource(){}
    public static RemoteDataSource getInstance() {
        if (sInstance == null) {
            synchronized (RemoteDataSource.class) {
                if (sInstance == null) sInstance = new RemoteDataSource();
            }
        }
        return sInstance;
    }

    public void loadStudents(Callback<StudentList> callback) {
        StudentService service = RetrofitHelper.getInstance();
        service.getStudents().enqueue(new retrofit2.Callback<StudentList>() {
            @Override
            public void onResponse(Call<StudentList> call, Response<StudentList> response) {
                if (response.isSuccessful()){
                    StudentList studentList = response.body();
                    if (studentList != null) {
                        mStudents.addAll(studentList.getStudents());
                        callback.onSuccess(studentList);
                    } else {
                        callback.onSuccess(null);
                        callback.onFailure(new Exception("No students data"));
                    }
                }
            }

            @Override
            public void onFailure(Call<StudentList> call, Throwable throwable) {
                callback.onFailure(new Exception(throwable.getMessage()));
                callback.onSuccess(null);
            }
        });
    }

    public Student getStudent(String id){
        Predicate<Student> predicate = student -> student.getmId().equals(id);
        return mStudents.stream().filter(predicate)
                .findFirst().orElse(null);
    }
}
