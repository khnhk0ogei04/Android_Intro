package com.example.gridview.data.source;

import com.example.gridview.data.model.Country;

import java.util.List;

public interface CountryDataSource {
    List<Country> loadData();
}
