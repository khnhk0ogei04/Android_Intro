package com.example.edittextview;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnRegister = findViewById(R.id.button_register);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if(view.getId() == R.id.button_register) {
            EditText txtFullName = findViewById(R.id.edit_full_name);
            EditText txtAddress = findViewById(R.id.edit_address);
            String fullName = txtFullName.getText().toString();
            String address = txtAddress.getText().toString();
            String msg = "Full Name: " + fullName + "\n" + "Address: " + address;
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        }
    }
}