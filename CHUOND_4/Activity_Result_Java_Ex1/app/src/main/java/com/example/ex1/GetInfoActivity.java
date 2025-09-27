package com.example.ex1;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex1.databinding.ActivityGetInfoBinding;

import java.util.Objects;

public class GetInfoActivity extends AppCompatActivity {
    private ActivityGetInfoBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityGetInfoBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setupViews();
    }

    private void setupViews(){
        mBinding.btnSubmit.setOnClickListener(v -> {
            String fullName = Objects.requireNonNull(mBinding.edtFullName.getText()).toString();
            String gpaStr = Objects.requireNonNull(mBinding.edtGpa.getText()).toString();
            float gpa = Float.parseFloat(gpaStr);
            Intent intent = new Intent();
            intent.putExtra(MainActivity.EXTRA_FULL_NAME, fullName);
            intent.putExtra(MainActivity.EXTRA_GPA, gpa);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

}