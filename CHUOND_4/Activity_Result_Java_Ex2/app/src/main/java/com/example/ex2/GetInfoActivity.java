package com.example.ex2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex2.databinding.ActivityGetInfoBinding;

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
            String fullName =
                    Objects.requireNonNull(mBinding.edtFullName.getText()).toString().trim();
            String gpaStr =
                    Objects.requireNonNull(mBinding.edtGpa.getText()).toString().trim();
            if (fullName.isEmpty()){
                mBinding.edtFullName.setError(getString(R.string.error_empty_full_name));
            }
            if (gpaStr.isEmpty()) {
                mBinding.edtGpa.setError(getString(R.string.error_empty_gpa));
                return;
            }
            float gpa = Float.parseFloat(gpaStr);
            Intent resultIntent = new Intent();
            resultIntent.putExtra(MainActivity.EXTRA_FULL_NAME, fullName);
            resultIntent.putExtra(MainActivity.EXTRA_GPA, gpa);
            setResult(RESULT_OK, resultIntent);
            finish();
        });
    }
}