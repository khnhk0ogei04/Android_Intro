package com.example.zodiac.data.repository

import com.example.zodiac.data.datasource.ZodiacLocalDataSource
import com.example.zodiac.data.model.Zodiac

class ZodiacRepositoryImpl(
    private val localDataSource: ZodiacLocalDataSource
): ZodiacRepository {
    override fun getZodiacs(): List<Zodiac> {
        return localDataSource.getZodiacs()
    }
}