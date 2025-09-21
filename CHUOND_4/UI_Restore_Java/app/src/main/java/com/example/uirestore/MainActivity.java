package com.example.uirestore;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.uirestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_FULL_NAME = "full_name";
    private static final String KEY_GPA = "gpa";
    private boolean mIsRecreated = false;
    private ActivityMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(mBinding.main, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mIsRecreated = savedInstanceState != null;
    }

    private void showData(String fullName, float gpa){
        mBinding.tvFullName.setText(getString(R.string.label_full_name, fullName));
        mBinding.tvGpa.setText(getString(R.string.label_gpa, gpa));
    }

    @Override
    protected void onResume(){
        super.onResume();
        if (!mIsRecreated){
            float gpa = 3.28f;
            String fullName = "Khanh Nguyen Duy";
            showData(fullName, gpa);
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState){
        super.onSaveInstanceState(outState);
        float gpa = 3.82f;
        String fullName = "Nguyen Duy Khanh";
        outState.putString(KEY_FULL_NAME, fullName);
        outState.putFloat(KEY_GPA, gpa);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        // restore data
        float gpa = savedInstanceState.getFloat(KEY_GPA);
        String fullName = savedInstanceState.getString(KEY_FULL_NAME);
        showData(fullName, gpa);
    }
}