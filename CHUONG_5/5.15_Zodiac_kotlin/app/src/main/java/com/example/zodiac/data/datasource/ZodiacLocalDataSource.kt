package com.example.zodiac.data.datasource

import com.example.zodiac.data.model.Zodiac

interface ZodiacLocalDataSource {
    fun getZodiacs(): List<Zodiac>
}