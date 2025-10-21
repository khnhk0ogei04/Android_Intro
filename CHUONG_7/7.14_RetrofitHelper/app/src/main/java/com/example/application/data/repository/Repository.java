package com.example.application.data.repository;

import com.example.application.data.model.SongList;

public interface Repository {
    void makeGetSongRequest(final RepositoryCallback<SongList> callback);
}
