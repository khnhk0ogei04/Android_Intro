package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class SongAdapter(
    private val context: Context,
    private val songs: List<Song>
): BaseAdapter() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun getCount(): Int {
        return songs.size
    }

    override fun getItem(position: Int): Any {
        return songs[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.song_item_layout, parent, false)
            holder = ViewHolder().apply {
                songImage = view.findViewById(R.id.songImage)
                songTitle = view.findViewById(R.id.songTitle)
                artistName = view.findViewById(R.id.artistName)
                moreOptionsButton = view.findViewById(R.id.moreOptionsButton)
            }
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val song = songs[position]
        holder.songTitle.text = song.songTitle
        holder.artistName.text = song.artistName

        holder.moreOptionsButton.setOnClickListener{
            Toast.makeText(
                context, "More options for: ${song.songTitle}", Toast.LENGTH_SHORT
            ).show()
        }
        return view
    }

    class ViewHolder {
        lateinit var songImage: ImageView
        lateinit var songTitle: TextView
        lateinit var artistName: TextView
        lateinit var moreOptionsButton: ImageButton
    }
}