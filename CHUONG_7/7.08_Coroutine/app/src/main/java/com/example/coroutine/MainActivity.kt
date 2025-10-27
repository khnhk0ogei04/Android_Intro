package com.example.coroutine

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.coroutine.adapter.SongListAdapter
import com.example.coroutine.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var songList: RecyclerView
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var adapter: SongListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        songList = findViewById(R.id.song_list)
        adapter = SongListAdapter(this, ArrayList())
        viewModel = MainActivityViewModel()
        songList.adapter = adapter

        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        songList.addItemDecoration(divider)

        val loadingProgress = findViewById<ProgressBar>(R.id.progress_bar)
        val imgNetworkError = findViewById<ImageView>(R.id.img_network_err)
        loadingProgress.visibility = View.VISIBLE

        viewModel.songList.observe(this) {
            loadingProgress.visibility = View.GONE
            if (it == null) {
                imgNetworkError.visibility = View.VISIBLE
            } else {
                imgNetworkError.visibility = View.GONE
                adapter.updateSongs(it)
            }
        }
    }
}