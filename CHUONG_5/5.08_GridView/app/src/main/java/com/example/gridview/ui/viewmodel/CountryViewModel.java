package com.example.gridview.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gridview.data.model.Country;
import com.example.gridview.data.source.CountryDataRepository;

import java.util.List;

public class CountryViewModel extends ViewModel {
    private final CountryDataRepository mRepository;
    private final MutableLiveData<List<Country>> _country = new MutableLiveData<>();
    public LiveData<List<Country>> country = _country;

    public CountryViewModel(CountryDataRepository repository) {
        mRepository = repository;
        loadData();
    }

    private void loadData(){
        List<Country> countryList = mRepository.loadData();
        if (countryList.size() > 0){
            _country.setValue(countryList);
        }
    }

}
