package com.example.fragment.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragment.data.repository.CountryRepository;

public class CountryViewModelFactory implements ViewModelProvider.Factory {
    private final CountryRepository repository;

    public CountryViewModelFactory(CountryRepository repository){
        this.repository = repository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass){
        if(modelClass.isAssignableFrom(CountryViewModel.class)) {
            return (T)(new CountryViewModel(repository));
        } else {
            throw new IllegalArgumentException("Class CountryViewModel not found.");
        }
    }
}
