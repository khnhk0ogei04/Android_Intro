package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity{
    private static final int REQUEST_CODE = 100;
    public static final String EXTRA_FULL_NAME = "full_name";
    public static final String EXTRA_GPA = "gpa";

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.tvResult.setVisibility(View.GONE);
        setupViews();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            String fullName = data.getStringExtra(EXTRA_FULL_NAME);
            float gpa = data.getFloatExtra(EXTRA_GPA, 0.0F);

            String result = getString(R.string.text_result, fullName, gpa);
            mBinding.tvResult.setVisibility(View.VISIBLE);
            mBinding.tvResult.setText(result);

        }
    }

    private void setupViews(){
        mBinding.btnStartActivity.setOnClickListener(v -> {
            Intent childActivityIntent = new Intent(this, GetInfoActivity.class);
            startActivityForResult(childActivityIntent, REQUEST_CODE);
        });
    }

}