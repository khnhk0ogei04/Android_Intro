package com.example.myapplication.repository;

import com.example.myapplication.model.Song;
import com.example.myapplication.model.SongList;
import com.example.myapplication.resource.Result;
import com.example.myapplication.resource.SongResponseParser;

import java.io.IOException;
import java.util.concurrent.Executor;

public class LoadSongRepository {
    private final Executor executor;
    private final SongResponseParser parser;

    public LoadSongRepository(SongResponseParser parser, Executor executor) {
        this.executor = executor;
        this.parser = parser;
    }

    public void makeGetSongRequest(final RepositoryCallback<SongList> callback){
        executor.execute(() -> {
            try {
                Result<SongList> result = makeSyncGetSongRequest();
                callback.onComplete(result);
            } catch (Exception ex) {
                Result<SongList> errorResult = new Result.Error<>(ex);
                callback.onComplete(errorResult);
            }
        });
    }

    public Result<SongList> makeSyncGetSongRequest() {
        String url = "https://thantrieu.com/resources/braniumapis/song.json";
        try {
            SongList songList = parser.parse(url);
            return new Result.Success<>(songList);
        } catch (IOException ex) {
            return new Result.Error<>(ex);
        }
    }


}
