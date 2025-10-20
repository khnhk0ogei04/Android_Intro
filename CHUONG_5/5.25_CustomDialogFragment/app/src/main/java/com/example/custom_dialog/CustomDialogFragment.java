package com.example.custom_dialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class CustomDialogFragment extends DialogFragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_custom_dialog, container, false);
        Button buttonCancel = view.findViewById(R.id.btn_cancel);
        Button buttonConfirm = view.findViewById(R.id.btn_ok);
        buttonCancel.setOnClickListener(this);
        buttonConfirm.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_cancel) {
            Toast.makeText(requireContext(), "Cancel Clicked", Toast.LENGTH_LONG).show();
        } else if (v.getId() == R.id.btn_ok) {
            Toast.makeText(requireContext(), "Confirm Clicked", Toast.LENGTH_LONG).show();
        }
        dismiss();
    }
}