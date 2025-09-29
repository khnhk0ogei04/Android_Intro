package com.example.linear_layout_ex1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textPhoneNumber;
    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;
    private Button btnLeft;
    private Button btnRight;
    private Button btnDelete;
    private Button btnCall;

    private PhoneCallViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initViews();
        registerEvent();
        model = new ViewModelProvider(this).get(PhoneCallViewModel.class);
        model.getCurrentNumber().observe(this, number -> {
            if (number.length() > 0) {
                btnDelete.setVisibility(View.VISIBLE);
            } else {
                btnDelete.setVisibility(View.INVISIBLE);
            }
            textPhoneNumber.setText(number);
        });
    }

    private void registerEvent() {
        // đăng ký sự kiện các nút được nhấn
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);
        btnLeft.setOnClickListener(this);
        btnRight.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnCall.setOnClickListener(this);
    }

    private void initViews(){
        textPhoneNumber = findViewById(R.id.text_phone_number);
        btnNumber0 = findViewById(R.id.btn_0);
        btnNumber1 = findViewById(R.id.btn_1);
        btnNumber2 = findViewById(R.id.btn_2);
        btnNumber3 = findViewById(R.id.btn_3);
        btnNumber4 = findViewById(R.id.btn_4);
        btnNumber5 = findViewById(R.id.btn_5);
        btnNumber6 = findViewById(R.id.btn_6);
        btnNumber7 = findViewById(R.id.btn_7);
        btnNumber8 = findViewById(R.id.btn_8);
        btnNumber9 = findViewById(R.id.btn_9);
        btnLeft = findViewById(R.id.btn_left);
        btnRight = findViewById(R.id.btn_right);
        btnDelete = findViewById(R.id.btn_del);
        btnCall = findViewById(R.id.btn_call);
    }

    @Override
    public void onClick(View view){
        if (view.getId() != R.id.btn_del && view.getId() != R.id.btn_call){
            model.appendNumber(((Button) view).getText().toString());
        } else if (view.getId() == R.id.btn_del) {
            model.removeANumber();
        } else if (view.getId() == R.id.btn_call &&
                textPhoneNumber.getText().toString().length() > 0) {
            String msg = "Calling " + textPhoneNumber.getText().toString();
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }
}