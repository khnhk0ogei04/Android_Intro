package com.example.myapplication.data;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
public final class RetrofitHelper {
    private static final String BASE_URL = "https://thantrieu.com/";
    private RetrofitHelper() {

    }

    public static StudentService getInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(JacksonConverterFactory.create())
                .build().create(StudentService.class);
    }
}
