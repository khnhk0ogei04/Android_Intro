package com.example.myapplication.data

import android.content.res.Resources
import com.example.myapplication.R
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import java.io.BufferedReader
import java.io.InputStreamReader

class LocalDataSource (
    private val resources: Resources
) {
    private val countries: MutableList<Country> = mutableListOf()

    companion object {
        @Volatile private var instance: LocalDataSource? = null

        fun getInstance(resources: Resources): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(resources).also { instance = it }
            }
    }

    fun getCountries(): List<Country> {
        if (countries.isEmpty()) {
            val json = readJsonFile()
            val mapper = jacksonObjectMapper()
            countries.addAll(mapper.readValue(json))
        }
        return countries
    }

    private fun readJsonFile(): String {
        val inputStream = resources.openRawResource(R.raw.country)
        return BufferedReader(InputStreamReader(inputStream)).use {it.readText()}
    }
    fun getCountry(countryName: String): Country? {
        if (countries.isEmpty()) {
            getCountries()
        }
        return countries.find { it.name == countryName }
    }
}