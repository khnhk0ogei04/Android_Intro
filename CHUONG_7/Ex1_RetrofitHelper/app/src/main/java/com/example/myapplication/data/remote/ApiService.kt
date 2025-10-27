package com.example.myapplication.data.remote

import retrofit2.Call
import com.example.myapplication.data.model.UsersResponse
import retrofit2.http.GET

interface ApiService {
    @GET("services/services.php/users")
    fun getUsers(): Call<UsersResponse>

}