package com.example.i;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.i.databinding.ActivityMainBinding;
import com.example.i.databinding.ActivitySampleBinding;

public class SampleActivity extends AppCompatActivity {
    private ActivitySampleBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivitySampleBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        showData();
    }

    private void showData() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String fullName = bundle.getString(MainActivity.EXTRA_FULL_NAME, "");
            int age = bundle.getInt(MainActivity.EXTRA_AGE, 0);
            String result = getString(R.string.text_result, fullName, age);
            mBinding.tvResult.setText(result);
        }
    }
}