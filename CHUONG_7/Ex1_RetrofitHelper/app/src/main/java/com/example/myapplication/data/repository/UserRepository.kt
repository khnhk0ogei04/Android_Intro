package com.example.myapplication.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapplication.data.model.User
import com.example.myapplication.data.model.UsersResponse
import com.example.myapplication.data.remote.RetrofitProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserRepository {
    fun fetchUsers(
        usersLiveData: MutableLiveData<List<User>>,
        errorLiveData: MutableLiveData<String?>
    ) {
        RetrofitProvider.api.getUsers().enqueue(object : Callback<UsersResponse> {
            override fun onResponse(p0: Call<UsersResponse>, p1: Response<UsersResponse>) {
                if (p1.isSuccessful) {
                    val data = p1.body()?.users.orEmpty()
                    usersLiveData.postValue(data)
                    errorLiveData.postValue(null)
                } else {
                    errorLiveData.postValue("Server error: ${p1.code()}")
                }
            }
            override fun onFailure(p0: Call<UsersResponse>, p1: Throwable) {
                errorLiveData.postValue(p1.message ?: "Network Error")
            }
        })
    }
}