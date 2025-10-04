package com.example.gridview.data.source;

import com.example.gridview.data.model.Country;

import java.util.List;

public class CountryDataRepository {
    private final CountryDataSource mDataSource;
    public CountryDataRepository(CountryDataSource mDataSource){
        this.mDataSource = mDataSource;
    }
    public List<Country> loadData(){
        return mDataSource.loadData();
    }
}
