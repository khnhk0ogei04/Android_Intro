package com.example.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RandomNumberFragment extends Fragment implements View.OnClickListener {
    private static final String IS_EDITING_KEY = "IS_EDITING_KEY";
    private static final String RANDOM_NUMBER_KEY = "RANDOM_NUMBER_KEY";

    private boolean isEditing;
    private long randomNumber;
    private EditText editTextRandomNumber;
    private Button btnEdit;
    private TextView textRandomNumber;
    private RandomNumberViewModel viewModel;
    private Button btnSave;
    private Button btnGenerate;

    public RandomNumberFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(RandomNumberViewModel.class);
        if (savedInstanceState != null) {
            isEditing = savedInstanceState.getBoolean(IS_EDITING_KEY, false);
            randomNumber = savedInstanceState.getLong(RANDOM_NUMBER_KEY);
        } else {
            randomNumber = viewModel.generateRandomNumber();
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_random_number, container, false);
        initView(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (savedInstanceState != null) {
            if (isEditing) {
                textRandomNumber.setVisibility(View.GONE);
                editTextRandomNumber.setVisibility(View.VISIBLE);
                editTextRandomNumber.setText(String.valueOf(randomNumber));
            } else {
                textRandomNumber.setText(String.valueOf(randomNumber));
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(IS_EDITING_KEY, isEditing);
        outState.putLong(RANDOM_NUMBER_KEY, randomNumber);
    }

    private void initView(View view){
        btnEdit = view.findViewById(R.id.btn_edit);
        btnSave = view.findViewById(R.id.btn_save);
        btnGenerate = view.findViewById(R.id.btn_generate);
        editTextRandomNumber = view.findViewById(R.id.edit_number);
        textRandomNumber = view.findViewById(R.id.text_number);

        btnGenerate.setOnClickListener(this);
        btnSave.setOnClickListener(this);
        btnEdit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_edit) {
            if (!isEditing) {
                isEditing = true;
                btnEdit.setText(getString(R.string.text_cancel));
                textRandomNumber.setVisibility(View.GONE);
                editTextRandomNumber.setVisibility(View.VISIBLE);
                editTextRandomNumber.setText(String.valueOf(randomNumber));
            } else {
                btnEdit.setText(getString(R.string.text_btn_edit));
                textRandomNumber.setVisibility(View.VISIBLE);
                editTextRandomNumber.setVisibility(View.GONE);
                textRandomNumber.setText(String.valueOf(randomNumber));
                isEditing = false;
            }
        } else if (v.getId() == R.id.btn_save) {
            if (isEditing) {
                String numberStr = editTextRandomNumber.getText().toString().trim();
                randomNumber = viewModel.stringToNumber(numberStr, randomNumber);
                viewModel.addNumberToList(randomNumber);
                isEditing = false;
                editTextRandomNumber.setVisibility(View.GONE);
                textRandomNumber.setVisibility(View.VISIBLE);
                textRandomNumber.setText(String.valueOf(randomNumber));
                btnEdit.setText(getString(R.string.text_btn_edit));
            }
        } else if (v.getId() == R.id.btn_generate) {
            if (!isEditing) {
                viewModel.setSeed();
                randomNumber = viewModel.generateRandomNumber();
                textRandomNumber.setText(String.valueOf(randomNumber));
            }
        }
    }
}