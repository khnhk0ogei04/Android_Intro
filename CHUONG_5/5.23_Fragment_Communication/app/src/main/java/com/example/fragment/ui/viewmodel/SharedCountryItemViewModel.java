package com.example.fragment.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment.data.model.Country;

public class SharedCountryItemViewModel extends ViewModel {
    private final MutableLiveData<Country> _selectedCountry = new MutableLiveData<>();
    public LiveData<Country> selectedCountry = _selectedCountry;

    public void setSelectedCountry(Country country) {
        _selectedCountry.setValue(country);
    }
}
