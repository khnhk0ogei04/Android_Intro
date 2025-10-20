package com.example.myapplication.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Country
import com.example.myapplication.data.LocalDataSource

class CountryViewModel (
    private val localDataSource: LocalDataSource
): ViewModel() {
    private val _countries = MutableLiveData<List<Country>>()
    val countries: LiveData<List<Country>> = _countries

    fun loadCountries() {
        _countries.value = localDataSource.getCountries()
    }

    class Factory(
        private val dataSource: LocalDataSource
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(CountryViewModel::class.java) ->
                    CountryViewModel(dataSource) as T
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            }
    }
}