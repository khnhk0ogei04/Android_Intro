package com.example.fragment.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fragment.MainActivity;
import com.example.fragment.R;

public class ResultFragment extends Fragment {
    private TextView textViewResult;

    public ResultFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParentFragmentManager().setFragmentResultListener(MainActivity.REQUEST_KEY, this, (requestKey, result) -> {
            int counter = result.getInt(MainActivity.BUNDLE_KEY);
            textViewResult.setText("Button was pressed: " + counter);
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        textViewResult = view.findViewById(R.id.text_result);
        return view;
    }
}