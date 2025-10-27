package com.example.coroutine.model

import com.google.gson.annotations.SerializedName

data class SongList(
    @SerializedName("song")
    var music: List<Song>
)
