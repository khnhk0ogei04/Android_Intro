package com.example.myapplication.data.model

data class User(
    val id: String,
    val userName: String,
    val email: String,
    val fullName: String,
    val displayName: String
)

data class UsersResponse (
    val users: List<User>
)