package com.example.listview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var songListView: ListView
    private lateinit var adapter: SongAdapter
    private val songs = mutableListOf<Song>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        songListView = findViewById(R.id.songListView)
        songs.add(
            Song("Song 1", "Artist 1", "https://example.com/song1.jpg")
        )
        songs.add(Song("Song 2", "Artist 2", "https://example.com/song2.jpg"))
        adapter = SongAdapter(this, songs)
        songListView.adapter = adapter
    }
}