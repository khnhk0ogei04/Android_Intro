package com.example.livedata_kotlin
import java.util.Date

data class Staff(
    var staffId: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var midName: String = "",
    var birthDate: Date = Date(),
    var salary: Long = 0
){
    override fun toString(): String {
        return "$staffId - $firstName - " + "${Utils.dateToString(birthDate)} - $salary"
    }
}