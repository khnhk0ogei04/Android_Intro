package com.example.ex2;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ex2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_FULL_NAME = "EXTRA_FULL_NAME";
    public static final String EXTRA_GPA = "EXTRA_GPA";

    private ActivityMainBinding mBinding;
    private final ActivityResultLauncher<Intent> mLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::handleResult);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setupViews();
    }

    private void handleResult(ActivityResult result){
        Intent data = result.getData();
        if (data != null && result.getResultCode() == RESULT_OK){
            String fullName = data.getStringExtra(EXTRA_FULL_NAME);
            float gpa = data.getFloatExtra(EXTRA_GPA, 0.0f);
            String resultStr = getString(R.string.text_result, fullName, gpa);
            mBinding.tvResult.setText(resultStr);
        } else {
            mBinding.tvResult.setText("No data");
        }
    }

    private void setupViews(){
        mBinding.btnStartActivity.setOnClickListener(v -> {
            Intent intent = new Intent(this, GetInfoActivity.class);
            mLauncher.launch(intent);
        });
    }
}