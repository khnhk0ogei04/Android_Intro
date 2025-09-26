package com.example.activityresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class GetInfoActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_get_info);
        Button btnSubmit = findViewById(R.id.btn_submit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        EditText editFullName = findViewById(R.id.edit_full_name);
        EditText editSalary = findViewById(R.id.edit_salary);
        String fullName = editFullName.getText().toString().trim();
        String salaryStr = editSalary.getText().toString().trim();
        double salary = 0;
        if (!salaryStr.isEmpty()){
            salary = Double.parseDouble(salaryStr);
        }
        Intent intent = new Intent();
        intent.putExtra(MainActivity.EXTRA_FULL_NAME, fullName);
        intent.putExtra(MainActivity.EXTRA_SALARY, salary);
        setResult(RESULT_OK, intent);
        finish();
    }
}