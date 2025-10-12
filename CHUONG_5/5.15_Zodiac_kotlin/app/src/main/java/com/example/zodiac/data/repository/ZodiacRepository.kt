package com.example.zodiac.data.repository

import com.example.zodiac.data.model.Zodiac

interface ZodiacRepository {
    fun getZodiacs(): List<Zodiac>
}