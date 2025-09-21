package com.example.exercise1;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_SCORE = "STATE_SCORE";
    private static final String STATE_LEVEL = "STATE_LEVEL";
    private static final String STATE_POWER = "STATE_POWER";
    private static final String STATE_NAME = "STATE_NAME";

    private TextView tvPlayer;
    private TextView tvScore;
    private TextView tvLevel;
    private TextView tvPower;

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
        setupView();
    }

    private void setupView(){
        tvPlayer = findViewById(R.id.txt_player);
        tvScore = findViewById(R.id.txt_score);
        tvPower = findViewById(R.id.txt_power);
        tvLevel = findViewById(R.id.txt_level);
    }

    private void showStates(String player, int level, int score, int power) {
        tvPlayer.setText(getString(R.string.label_player, player));
        tvScore.setText(getString(R.string.label_score, score));
        tvPower.setText(getString(R.string.label_power, power));
        tvLevel.setText(getString(R.string.label_level, level));
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        int score = savedInstanceState.getInt(STATE_SCORE);
        int level = savedInstanceState.getInt(STATE_LEVEL);
        int power = savedInstanceState.getInt(STATE_POWER);
        String player = savedInstanceState.getString(STATE_NAME);

        showStates(player, level, score, power);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        int currentScore = 99;
        int currentLevel = 30;
        int currentPower = 980;
        String playerName = "Nguyen Khanh 01";
        showStates(playerName, currentLevel, currentScore, currentPower);
        outState.putString(STATE_NAME, playerName);
        outState.putInt(STATE_SCORE, currentScore);
        outState.putInt(STATE_LEVEL, currentLevel);
        outState.putInt(STATE_POWER, currentPower);
    }
}