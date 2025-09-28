package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InfoActivity extends AppCompatActivity {

    private EditText editFullName;
    private EditText editSalary;
    private EditText editFamilyMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_info);

        editFullName = findViewById(R.id.edit_name);
        editSalary = findViewById(R.id.edit_salary);
        editFamilyMember = findViewById(R.id.edit_family_members);

        fillData();
    }

    private void fillData(){
        Intent receivedIntent = getIntent();

        String name = receivedIntent.getStringExtra(ExtraUtils.EXTRA_NAME);
        float salary = receivedIntent.getFloatExtra(ExtraUtils.EXTRA_SALARY, 0);

        String[] familyMembers = receivedIntent.getStringArrayExtra(ExtraUtils.EXTRA_FAMILY_MEMBERS_NAMES);
        StringBuilder member = new StringBuilder();
        for (String str: familyMembers){
            member.append(str).append(", ");
        }
        editSalary.setText(salary + "");
        editFullName.setText(name);
        editFamilyMember.setText(member.toString());
    }
}