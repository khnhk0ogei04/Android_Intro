package com.example.i;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.i.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_FULL_NAME = "extra_full_name";
    public static final String EXTRA_AGE = "extra_age";

    private ActivityMainBinding mBinding;
    @SuppressLint("UnsafeImplicitIntentLaunch")
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

        mBinding.btnSubmit.setOnClickListener(v -> {
           Intent intent = new Intent(this, SampleActivity.class);
           Bundle bundle = new Bundle();
           String fullName = String.valueOf(mBinding.txtFullName.getText());
           String ageStr = String.valueOf(mBinding.txtAge.getText());
           int age = 0;
           if (!ageStr.isEmpty()){
               age = Integer.parseInt(ageStr);
           }
           bundle.putInt(EXTRA_AGE, age);
           bundle.putString(EXTRA_FULL_NAME, fullName);
           intent.putExtras(bundle);
           startActivity(intent);
        });

//        mBinding.btnLaunchActivity.setOnClickListener(v -> {
//            Intent intent = new Intent();
//            intent.setAction(Intent.ACTION_VIEW);
//            intent.addCategory(Intent.CATEGORY_DEFAULT);
//            startActivity(intent);
//        });
    }
}