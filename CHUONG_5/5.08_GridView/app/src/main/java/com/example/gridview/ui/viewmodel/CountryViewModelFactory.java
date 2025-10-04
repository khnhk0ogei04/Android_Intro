package com.example.gridview.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.gridview.data.source.CountryDataRepository;

public class CountryViewModelFactory implements ViewModelProvider.Factory {
    private final CountryDataRepository mRepository;

    public CountryViewModelFactory(CountryDataRepository mRepository){
        this.mRepository = mRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(CountryViewModel.class)) {
            return (T) new CountryViewModel(mRepository);
        } else {
            throw new IllegalArgumentException("Argument is not class CountryViewModel");
        }
    }
}
