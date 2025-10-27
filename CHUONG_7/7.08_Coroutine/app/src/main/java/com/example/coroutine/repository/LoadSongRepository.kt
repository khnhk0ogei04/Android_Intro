package com.example.coroutine.repository

import com.example.coroutine.model.SongList
import com.example.coroutine.resource.SongResponseParser
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import com.example.coroutine.resource.Result

class LoadSongRepository (
    private val parser: SongResponseParser
) {
    companion object {
        const val URL = "https://thantrieu.com/resources/braniumapis/song.json"
    }
    suspend fun loadSongs(): Result<SongList> {
        return withContext(Dispatchers.IO) {
            val result = try {
                val response = parser.parse(URL)
                Result.Success(response)
            } catch (ex: IOException) {
                Result.Error(ex)
            }
            result
        }
    }
}