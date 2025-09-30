package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NameViewModel: ViewModel() {
    private val _currentName = MutableLiveData<String>()
    val currentName: LiveData<String> = _currentName
    fun updateName(fullName: String){
        _currentName.value = fullName
    }
}