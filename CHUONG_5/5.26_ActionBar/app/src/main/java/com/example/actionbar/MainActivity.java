package com.example.actionbar;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.actionbar.fragment.EditFragment;
import com.example.actionbar.fragment.StudentFragment;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements StudentFragment.OnStudentEditListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container, StudentFragment.getInstance(this))
                .commit();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Objects.requireNonNull(getSupportActionBar()).show();
    }

    @Override
    public void onClick() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(null)
                .setReorderingAllowed(true)
                .replace(R.id.fragment_container, EditFragment.class, null)
                .commit();
    }
}