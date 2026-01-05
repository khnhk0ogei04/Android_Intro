package com.example.myapplication.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myapplication.model.Song;
import com.example.myapplication.model.SongList;
import com.example.myapplication.repository.LoadSongRepository;
import com.example.myapplication.resource.Result;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final LoadSongRepository repository;
    private final MutableLiveData<List<Song>> _songs;
    public LiveData<List<Song>> songs;

    public MainActivityViewModel(LoadSongRepository repository){
        this.repository = repository;
        this._songs = new MutableLiveData<>();
        this.songs = _songs;
        loadSongs();
    }

    public void loadSongs() {
        repository.makeGetSongRequest(result -> {
            if (result instanceof Result.Success){
                _songs.postValue(((Result.Success<SongList>) result).data.songs);
            } else {
                _songs.postValue(null);
            }
        });
    }
}
