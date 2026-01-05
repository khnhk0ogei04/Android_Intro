package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.adapter.SongListAdapter;
import com.example.myapplication.repository.LoadSongRepository;
import com.example.myapplication.resource.SongResponseParser;
import com.example.myapplication.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SongListAdapter adapter;
    private RecyclerView songList;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();
        adapter = new SongListAdapter(this, new ArrayList<>());
        MyApplication myApplication = new MyApplication();
        SongResponseParser parser = new SongResponseParser();
        LoadSongRepository repository = new LoadSongRepository(parser, myApplication.executorService);
        viewModel = new MainActivityViewModel(repository);
        songList.setAdapter(adapter);
        registerObserver();
    }

    private void registerObserver(){
        ProgressBar progressBar = findViewById(R.id.progress_bar);
        ImageView imgNetworkError = findViewById(R.id.img_no_internet);
        progressBar.setVisibility(View.VISIBLE);
        viewModel.songs.observe(this, songs -> {
            progressBar.setVisibility(View.GONE);
            if (songs == null) {
                imgNetworkError.setVisibility(View.VISIBLE);
            } else {
                imgNetworkError.setVisibility(View.GONE);
                adapter.updateSongs(songs);
            }
        });
    }

    private void initViews(){
        songList = findViewById(R.id.song_list);
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        songList.addItemDecoration(divider);
    }

}