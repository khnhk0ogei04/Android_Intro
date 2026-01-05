package com.example.myapplication.resource;

import com.example.myapplication.model.SongList;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class SongResponseParser {
    public SongList parse (String url) throws IOException {
        URL urlConn = new URL(url);
        InputStreamReader inputStreamReader = new InputStreamReader(urlConn.openStream());
        BufferedReader reader = new BufferedReader(inputStreamReader);
        Gson gson = new Gson();
        return gson.fromJson(reader, SongList.class);
    }
}
