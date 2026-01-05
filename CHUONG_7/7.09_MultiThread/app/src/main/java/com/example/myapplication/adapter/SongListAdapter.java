package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.model.Song;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {
    private final List<Song> songs;
    private final Context context;

    public SongListAdapter(Context context, List<Song> songs) {
        this.songs = songs;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.song_item, parent, false);
        return new ViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public void updateSongs(List<Song> songs) {
        this.songs.clear();
        this.songs.addAll(songs);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private Context context;
        private TextView textSongTitle;
        private TextView textSongArtist;
        private ImageView imageSong;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public ViewHolder (Context context, @NonNull View view){
            this(view);
            this.context = context;
            textSongArtist = view.findViewById(R.id.text_song_artist);
            textSongTitle = view.findViewById(R.id.text_song_title);
            imageSong = view.findViewById(R.id.img_song);
        }

        public void bind(Song song) {
            this.textSongArtist.setText(song.getArtist());
            this.textSongTitle.setText(song.getTitle());
            Glide.with(context).load(song.getImage()).error(R.drawable.ic_album)
                    .into(imageSong);
        }
    }
}
