package com.example.application.data.resource;

import com.example.application.data.model.SongList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface AppService {
    @GET("resources/braniumapis/song.json")
    Call<SongList> listSong();
}
