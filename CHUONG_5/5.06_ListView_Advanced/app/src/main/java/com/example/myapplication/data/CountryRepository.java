package com.example.myapplication.data;

import java.util.List;

public class CountryRepository {
    private final LocalDataSource mLocalDataSource;

    public CountryRepository(LocalDataSource localDataSource){
        mLocalDataSource = localDataSource;
    }

    public List<Country> loadCountries(){
        return mLocalDataSource.loadCountries();
    }
}
