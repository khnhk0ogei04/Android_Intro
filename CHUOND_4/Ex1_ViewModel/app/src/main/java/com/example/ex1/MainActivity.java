package com.example.ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private StaffViewModel model;
    private Button btnAddNew;
    private EditText editStaffId;
    private EditText editFullName;
    private EditText editSalary;
    private EditText editBirthDate;
    private TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        // done 3: bind views to variables
        initViews();
        // done 4: register event for button
        btnAddNew.setOnClickListener(this);
        // done 5: add observer for ViewModel object
        addObserver();
    }

    private void addObserver(){
        model = new ViewModelProvider(this).get(StaffViewModel.class);
        model.getStaffs().observe(this, staffs -> {
            if (staffs.size() == 0) {
                textResult.setText("No Result!");
            } else {
                StringBuilder builder = new StringBuilder();
                for (Staff staff : staffs) {
                    builder.append(staff.toString()).append("\n");
                }
                textResult.setText(builder.toString());
            }
        });
    }

    private void initViews() {
        textResult = findViewById(R.id.text_result);
        editBirthDate = findViewById(R.id.edit_birth_date);
        editStaffId = findViewById(R.id.edit_id);
        editFullName = findViewById(R.id.edit_full_name);
        editSalary = findViewById(R.id.edit_salary);
        btnAddNew = findViewById(R.id.button_add_staff);
    }

    @Override
    public void onClick(View view){
        String staffId = editStaffId.getText().toString();
        String fullName = editFullName.getText().toString();
        String birthDate = editBirthDate.getText().toString();
        String salaryStr = editSalary.getText().toString();
        long salary = Long.parseLong(salaryStr);
        model.addStaff(staffId, fullName, birthDate, salary);
    }
}