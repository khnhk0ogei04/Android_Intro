package com.example.viewpager.data.repository;

import com.example.viewpager.data.datasource.ZodiacLocalDataSource;
import com.example.viewpager.data.model.Zodiac;

import java.util.List;

public class ZodiacRepositoryImpl implements ZodiacRepository{
    private final ZodiacLocalDataSource mLocalDataSource;

    public ZodiacRepositoryImpl(ZodiacLocalDataSource dataSource) {
        mLocalDataSource = dataSource;
    }
    @Override
    public List<Zodiac> getZodiacs() {

        return mLocalDataSource.getZodiacs();
    }
}
