package com.example.application.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.application.R;
import com.example.application.data.model.Song;
import com.example.application.databinding.SongItemBinding;

import java.util.List;

public class SongListAdapter extends RecyclerView.Adapter<SongListAdapter.ViewHolder> {
    private final List<Song> songs;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Song song);
    }

    public SongListAdapter(List<Song> songs, OnItemClickListener listener) {
        this.songs = songs;
        this.listener = listener;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void updateSongs(List<Song> updateList) {
        this.songs.clear();
        this.songs.addAll(updateList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_item, parent, false);
        SongItemBinding binding = SongItemBinding.bind(adapterView);
        return new ViewHolder(parent.getContext(), binding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(songs.get(position));
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private SongItemBinding binding;
        private Context context;
        private OnItemClickListener listener;
        private Song currentSong;

        public ViewHolder(Context context, SongItemBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.context = context;
            this.binding = binding;
            this.listener = listener;
            binding.getRoot().setOnClickListener(this);
        }

        public void bind(Song song) {
            this.currentSong = song;
            binding.textArtist.setText(song.getArtist());
            binding.textTitle.setText(song.getTitle());
            Glide.with(context)
                    .load(song.getImage())
                    .error(R.drawable.ic_album).into(binding.imageAlbum);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(
                    context,
                    "🎵 " + currentSong.getTitle() + " - " + currentSong.getArtist(),
                    Toast.LENGTH_SHORT
            ).show();
        }
    }
}
