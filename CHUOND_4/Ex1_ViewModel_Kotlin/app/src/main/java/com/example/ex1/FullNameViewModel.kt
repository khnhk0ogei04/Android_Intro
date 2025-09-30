package com.example.ex1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FullNameViewModel: ViewModel() {
    private val _fullName = MutableLiveData<String>()
    val fullName: LiveData<String> = _fullName
    fun setCurrentFullName(name: String){
        _fullName.value = name.trim()
    }
}