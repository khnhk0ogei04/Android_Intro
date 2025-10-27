package com.example.coroutine.viewmodel

import androidx.lifecycle.LiveData
import com.example.coroutine.resource.Result
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.coroutine.model.Song
import com.example.coroutine.repository.LoadSongRepository
import com.example.coroutine.resource.SongResponseParser
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class MainActivityViewModel(
    private val parser: SongResponseParser = SongResponseParser(),
    private val repository: LoadSongRepository = LoadSongRepository(parser)
) : ViewModel() {
    private val _songList = MutableLiveData<List<Song>?>()
    val songList: LiveData<List<Song>?>
        get() = _songList

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            val result = repository.loadSongs()
            if (result is Result.Success) {
                _songList.postValue(result.data.music)
            } else {
                _songList.postValue(null)
            }
        }
    }
}