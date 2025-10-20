package com.example.myapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.data.Country
import com.example.myapplication.data.LocalDataSource
import com.example.myapplication.ui.CountryViewModel

class CountryDetailViewModel (
    private val localDataSource: LocalDataSource
) : ViewModel() {

    private val _country = MutableLiveData<Country>()
    val country: LiveData<Country> = _country

    fun getCountryByName(name: String) {
        val result = localDataSource.getCountry(name)
        _country.value = result
    }

    class Factory(
        private val dataSource: LocalDataSource
    ): ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            when {
                modelClass.isAssignableFrom(CountryDetailViewModel::class.java) ->
                    CountryDetailViewModel(dataSource) as T
                else -> throw IllegalArgumentException("Unknown ViewModel class")
            }
    }
}