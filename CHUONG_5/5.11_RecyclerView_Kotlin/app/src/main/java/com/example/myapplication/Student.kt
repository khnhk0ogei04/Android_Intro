package com.example.myapplication

import com.fasterxml.jackson.annotation.JsonProperty

data class Student(
    @JsonProperty("id")
    val id: String,
    @JsonProperty("full_name") val fullName: FullName,
    @JsonProperty("gender") val gender: String,
    @JsonProperty("birth_date") val birthDate: String,
    @JsonProperty("email") val email: String,
    @JsonProperty("address") val address: String,
    @JsonProperty("major") val major: String,
    @JsonProperty("gpa") val gpa: Float,
    @JsonProperty("year") val year: Int
)

data class FullName(
    @JsonProperty("first") val first: String,
    @JsonProperty("last") val last: String,
    @JsonProperty("mid") val mid: String
) {
    override fun toString(): String {
        return "$last $mid $first"
    }
}
