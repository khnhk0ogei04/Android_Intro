package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnStartNew = findViewById(R.id.btn_start_new);
        btnStartNew.setOnClickListener(v -> {
            Intent intent = createIntent();
            startActivity(intent);
        });
    }

    private Intent createIntent(){
        String fullName = "Khanh Nguyen Duy";
        float salary = 11.0f;
        String[] familyMemberNames = {"Ky", "Nhung", "Chi", "Long", "Cuong"};
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(ExtraUtils.EXTRA_NAME, fullName);
        intent.putExtra(ExtraUtils.EXTRA_SALARY, salary);
        intent.putExtra(ExtraUtils.EXTRA_FAMILY_MEMBERS_NAMES, familyMemberNames);
        return intent;
    }
}