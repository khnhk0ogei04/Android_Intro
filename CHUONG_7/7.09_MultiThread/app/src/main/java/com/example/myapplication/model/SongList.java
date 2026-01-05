package com.example.myapplication.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SongList {
    @SerializedName("song")
    public List<Song> songs = new ArrayList<>();
}
