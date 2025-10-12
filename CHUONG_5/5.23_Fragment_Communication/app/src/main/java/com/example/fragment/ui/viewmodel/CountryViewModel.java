package com.example.fragment.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.fragment.data.model.Country;
import com.example.fragment.data.repository.CountryRepository;

import java.util.List;

public class CountryViewModel extends ViewModel {
    private final MutableLiveData<List<Country>> _country = new MutableLiveData<>();
    public LiveData<List<Country>> country = _country;
    private final CountryRepository repository;

    public CountryViewModel(CountryRepository repository) {
        this.repository = repository;
        loadData();
    }

    private void loadData(){
        List<Country> countryList = repository.getCountries();
        if (countryList != null) {
            _country.setValue(countryList);
        }
    }
}
