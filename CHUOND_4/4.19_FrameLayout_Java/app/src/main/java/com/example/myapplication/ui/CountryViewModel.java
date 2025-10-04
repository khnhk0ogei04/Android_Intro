package com.example.myapplication.ui;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.Country;
import com.example.myapplication.data.CountryRepository;

import java.util.List;

public class CountryViewModel extends ViewModel {
    private final CountryRepository mCountryRepository;
    private final MutableLiveData<List<Country>> mCountries = new MutableLiveData<>();

    public CountryViewModel(CountryRepository countryRepository) {
        mCountryRepository = countryRepository;
    }

    public LiveData<List<Country>> getCountries() {
        return mCountries;
    }

    public void loadCountries() {
        List<Country> countries = mCountryRepository.loadCountries();
        mCountries.setValue(countries);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final CountryRepository mCountryRepository;

        public Factory(CountryRepository countryRepository) {
            mCountryRepository = countryRepository;
        }

        @SuppressWarnings("unchecked")
        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            if (modelClass.isAssignableFrom(CountryViewModel.class)) {
                return (T) new CountryViewModel(mCountryRepository);
            } else {
                throw new IllegalArgumentException("Unknown ViewModel class");
            }
        }
    }
}
