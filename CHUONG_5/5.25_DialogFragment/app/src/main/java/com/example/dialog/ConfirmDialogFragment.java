package com.example.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class ConfirmDialogFragment extends DialogFragment{
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new AlertDialog.Builder(requireContext())
                .setMessage("Are you want to delete this dialog?")
                .setPositiveButton("OK", (dialog, which) -> {
                    Toast.makeText(
                            requireContext(), "Clicked OK" + which, Toast.LENGTH_LONG
                    ).show();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    Toast.makeText(requireContext(), "Clicked Cancel " + which, Toast.LENGTH_LONG).show();
                }).create();
    }
}
