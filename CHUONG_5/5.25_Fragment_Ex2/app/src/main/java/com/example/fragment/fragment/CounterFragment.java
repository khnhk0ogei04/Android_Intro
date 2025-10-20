package com.example.fragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragment.MainActivity;
import com.example.fragment.R;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterFragment extends Fragment {
    public CounterFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_counter, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCount = view.findViewById(R.id.btn_count);
        Bundle bundle = new Bundle();
        AtomicInteger counter = new AtomicInteger();
        btnCount.setOnClickListener(v -> {
            counter.getAndIncrement();
            bundle.putInt(MainActivity.BUNDLE_KEY, counter.get());
            getParentFragmentManager().setFragmentResult(MainActivity.REQUEST_KEY, bundle);
            btnCount.setEnabled(false);
        });
    }
}