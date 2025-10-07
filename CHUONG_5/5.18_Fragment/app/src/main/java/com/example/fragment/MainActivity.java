package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private boolean isShowingSecond = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fragmentContainer, new FirstFragment());
        transaction.commit();

        Button btnSwitch = findViewById(R.id.btnSwitchFragment);
        btnSwitch.setOnClickListener(v -> {
            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
            if (!isShowingSecond) {
                transaction1.replace(R.id.fragmentContainer, new SecondFragment());
                transaction1.addToBackStack(null);
                transaction1.commit();
                btnSwitch.setText("Switch to First Fragment");
                isShowingSecond = true;
            } else {
                getSupportFragmentManager().popBackStack();
                btnSwitch.setText("Switch to Second Fragment");
                isShowingSecond = false;
            }
        });
    }
}