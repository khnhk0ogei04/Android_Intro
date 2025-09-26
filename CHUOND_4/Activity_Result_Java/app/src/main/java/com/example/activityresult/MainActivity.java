package com.example.activityresult;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_CODE = 100;
    public static final String EXTRA_FULL_NAME = "EXTRA_FULL_NAME";
    public static final String EXTRA_SALARY = "EXTRA_SALARY";
    private TextView textResult;

    private ActivityResultLauncher<Intent> myLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button btnStartNew = findViewById(R.id.btn_start_new);
        textResult = findViewById(R.id.text_result);
        myLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), this::handleResult);
    //    btnStartNew.setOnClickListener(v -> {
    //        Intent intent = new Intent(this, GetInfoActivity.class);//
    //        startActivityForResult(intent, REQUEST_CODE);
    //    });
        btnStartNew.setOnClickListener(this);
    }

    /**
     * Phương thức xử lý kết quả bắn về từ callback đã đăng ký ở trên.
     * @param result: đối tượng chứa dữ liệu trả về từ activity con sau khi kết thúc nhiệm vụ.
     */
    private void handleResult(ActivityResult result) {
        Intent data = result.getData();
        if (data != null && result.getResultCode() == RESULT_OK) {
            double salary = data.getDoubleExtra(EXTRA_SALARY, 0);
            String fullName = data.getStringExtra(EXTRA_FULL_NAME);
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##đ");
            String builder = "Full Name: " + fullName +
                    "\n" + "Salary: " +
                    decimalFormat.format(salary);
            textResult.setText(builder);
        } else {
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, GetInfoActivity.class);
        myLauncher.launch(intent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
//        super.onActivityResult(requestCode, resultCode, data);
//        if (data != null && requestCode == REQUEST_CODE && resultCode == RESULT_OK){
//            double salary = data.getDoubleExtra(EXTRA_SALARY, 0);
//            String fullName = data.getStringExtra(EXTRA_FULL_NAME);
//            DecimalFormat decimalFormat = new DecimalFormat("#,###.##đ");
//            StringBuilder builder = new StringBuilder();
//            builder.append("Full Name: ").append(fullName);
//            builder.append("\n").append("Salary: ");
//            builder.append(decimalFormat.format(salary));
//            textResult.setText(builder.toString());
//        } else {
//            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
//        }
//    }
}