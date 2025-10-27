package com.example.coroutine.resource

import com.example.coroutine.model.SongList
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.URL
import kotlin.jvm.Throws

class SongResponseParser {
    @Throws(IOException::class)
    fun parse(url: String): SongList {
        val musicConn = URL(url)
        val reader = BufferedReader(InputStreamReader(musicConn.openStream()))
        return Gson().fromJson(reader, SongList::class.java)
    }
}