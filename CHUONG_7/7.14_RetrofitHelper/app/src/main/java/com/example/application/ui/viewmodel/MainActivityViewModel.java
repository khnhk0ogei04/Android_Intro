package com.example.application.ui.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.application.data.model.Song;
import com.example.application.data.model.SongList;
import com.example.application.data.repository.Repository;
import com.example.application.data.resource.Result;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private final Repository repository;
    private final MutableLiveData<List<Song>> _songs;
    public LiveData<List<Song>> songs;

    public MainActivityViewModel(Repository repository){
        this.repository = repository;
        this._songs = new MutableLiveData<>();
        this.songs = _songs;
        loadSongs();
    }

    private void loadSongs() {
        repository.makeGetSongRequest(result -> {
            if (result instanceof Result.Success) {
                _songs.postValue(((Result.Success<SongList>) result).data.getSongs());
            } else {
                _songs.postValue(null);
            }
        });
    }
}
