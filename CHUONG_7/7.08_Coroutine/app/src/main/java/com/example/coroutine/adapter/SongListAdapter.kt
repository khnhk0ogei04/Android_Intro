package com.example.coroutine.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coroutine.R
import com.example.coroutine.model.Song
import com.google.android.material.snackbar.Snackbar

class SongListAdapter (
    private val context: Context,
    private val songs: MutableList<Song>
): RecyclerView.Adapter<SongListAdapter.ViewHolder>() {
    class ViewHolder(
        private val context: Context,
        private val view: View
    ): RecyclerView.ViewHolder(view) {
        private val textArtist = view.findViewById<TextView>(R.id.text_song_artist)
        private val textTitle = view.findViewById<TextView>(R.id.text_song_title)
        private val imageSong = view.findViewById<ImageView>(R.id.img_album)

        fun bind(song: Song) {
            textTitle.text = song.title
            textArtist.text = song.artist
            Glide.with(context)
                .load(song.image)
                .error(R.drawable.ic_album)
                .into(imageSong)
            view.setOnClickListener {
                Snackbar.make(
                    view,
                    "Bạn vừa chọn: ${song.title} - ${song.artist}",
                    Snackbar.LENGTH_SHORT
                ).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapterView = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false)
        return ViewHolder(context, adapterView)
    }

    override fun getItemCount(): Int {
        return songs.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(songs[position])
    }

    fun updateSongs(songs: List<Song>){
        this.songs.clear()
        this.songs.addAll(songs)
        notifyDataSetChanged()
    }
}