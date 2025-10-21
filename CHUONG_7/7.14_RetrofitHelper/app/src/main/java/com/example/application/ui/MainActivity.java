package com.example.application.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DividerItemDecoration;

import com.example.application.R;
import com.example.application.data.repository.RemoteRepository;
import com.example.application.data.repository.Repository;
import com.example.application.databinding.ActivityMainBinding;
import com.example.application.ui.adapter.SongListAdapter;
import com.example.application.ui.viewmodel.MainActivityViewModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity{
    private ActivityMainBinding binding;
    private SongListAdapter adapter;
    private MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        initViews();
        adapter = new SongListAdapter(new ArrayList<>(), song -> {
            Log.d("SongClick", "Clicked song: " + song.getTitle());
        });
        Repository repository = new RemoteRepository();
        viewModel = new MainActivityViewModel(repository);
        binding.songList.setAdapter(adapter);
        registerObserver();
    }

    private void registerObserver() {
        binding.progressBar.setVisibility(View.VISIBLE);
        viewModel.songs.observe(this, songs -> {
            binding.progressBar.setVisibility(View.GONE);
            if (songs == null) {
                binding.imageNoInternet.setVisibility(View.VISIBLE);
            } else {
                binding.imageNoInternet.setVisibility(View.GONE);
                adapter.updateSongs(songs);
            }
        });
    }

    private void initViews(){
        DividerItemDecoration divider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        binding.songList.addItemDecoration(divider);
    }
}