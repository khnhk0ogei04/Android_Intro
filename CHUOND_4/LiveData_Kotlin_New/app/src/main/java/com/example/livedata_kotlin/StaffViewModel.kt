package com.example.livedata_kotlin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class StaffViewModel: ViewModel() {
    private val _staff = MutableLiveData<MutableList<Staff>>()
    val staff: LiveData<MutableList<Staff>> = _staff
    init {
        _staff.value = mutableListOf()

    }
    fun addStaff(id: String, fullName: String, birthDate: String, salary: Long){
        val names = fullName.split("\\s+".toRegex()).dropLastWhile {
            it.isEmpty()
        }
        var first = ""
        var last = ""
        var mid = StringBuilder()
        if (names.size == 1){
            first = names[0]
        } else if (names.size == 2){
            first = names[1]
            last = names[0]
        } else if (names.size >= 3){
            first = names[names.size - 1]
            last = names[0]
            for (i in 1 .. names.size - 2){
                mid.append(names[i]).append(" ")
            }
        }
        val date = Utils.stringToDate(birthDate)
        val staff = Staff(id, first, last, mid.toString().trim(), date, salary)
        _staff.notifyObserver(staff)
    }
}

fun <T> MutableLiveData<MutableList<T>>.notifyObserver(item: T) {
    val items = this.value ?: mutableListOf()
    items.add(item)
    this.value = items
}