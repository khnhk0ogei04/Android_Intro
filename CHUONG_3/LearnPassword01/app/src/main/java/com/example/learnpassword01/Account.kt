package com.example.learnpassword01

data class Account(
    val email: String,
    val password: String
){
    override fun hashCode(): Int {
        var result = email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Account
        if (email != other.email) return false
        if (password != other.password) return false
        return true
    }

}
