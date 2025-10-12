package com.example.zodiac.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.zodiac.data.datasource.ZodiacLocalDataSourceImpl
import com.example.zodiac.data.model.Zodiac
import com.example.zodiac.data.repository.ZodiacRepository
import com.example.zodiac.data.repository.ZodiacRepositoryImpl

class ZodiacViewModel: ViewModel() {
    private val repository: ZodiacRepository = ZodiacRepositoryImpl(ZodiacLocalDataSourceImpl())

    private val _zodiacs = MutableLiveData<List<Zodiac>>()
    val zodiacs: LiveData<List<Zodiac>> = _zodiacs

    init {
        _zodiacs.value = repository.getZodiacs()
    }

    fun getZodiacAtPosition(position: Int): Zodiac? =
        _zodiacs.value?.getOrNull(position)
}