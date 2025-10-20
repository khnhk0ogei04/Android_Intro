package com.example.dialog;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button buttonShowConfirm = findViewById(R.id.btn_show_confirm);
        buttonShowConfirm.setOnClickListener(v -> {
            new ConfirmDialogFragment().show(getSupportFragmentManager(), "TAG");
        });
    }
}