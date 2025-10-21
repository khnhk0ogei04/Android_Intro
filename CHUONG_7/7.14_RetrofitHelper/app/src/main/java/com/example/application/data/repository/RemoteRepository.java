package com.example.application.data.repository;

import com.example.application.data.model.Song;
import com.example.application.data.model.SongList;
import com.example.application.data.resource.AppService;
import com.example.application.data.resource.Result;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteRepository implements Repository{
    @Override
    public void makeGetSongRequest(RepositoryCallback<SongList> callback) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://thantrieu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        AppService service = retrofit.create(AppService.class);
        Call<SongList> songListCall = service.listSong();
        songListCall.enqueue(new Callback<SongList>() {
            @Override
            public void onResponse(Call<SongList> call, Response<SongList> response) {
                callback.onComplete(new Result.Success<>(response.body()));
            }

            @Override
            public void onFailure(Call<SongList> call, Throwable throwable) {
                callback.onComplete(new Result.Error<>(new Exception(throwable.getMessage())));
            }
        });
    }
}
