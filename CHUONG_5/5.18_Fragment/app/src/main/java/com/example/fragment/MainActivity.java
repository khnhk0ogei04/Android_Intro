package com.example.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
//     private boolean isShowingSecond = false;
    private enum Stage {
        FIRST,
        SECOND,
        THIRD
    }

    private Stage current = Stage.FIRST;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.add(R.id.fragmentContainer, new FirstFragment());
//        transaction.commit();
        if (savedInstanceState == null) {
            replaceFragment(new FirstFragment());
            current = Stage.FIRST;
        }
        Button btnSwitch = findViewById(R.id.btnSwitchFragment);
        btnSwitch.setText("Next (Second Fragment)");
//        btnSwitch.setOnClickListener(v -> {
//            FragmentTransaction transaction1 = getSupportFragmentManager().beginTransaction();
//            if (!isShowingSecond) {
//                transaction1.replace(R.id.fragmentContainer, new SecondFragment());
//                transaction1.addToBackStack(null);
//                transaction1.commit();
//                btnSwitch.setText("Switch to First Fragment");
//                isShowingSecond = true;
//            } else {
//                getSupportFragmentManager().popBackStack();
//                btnSwitch.setText("Switch to Second Fragment");
//                isShowingSecond = false;
//            }
//        });
        btnSwitch.setOnClickListener(v -> {
            switch (current) {
                case FIRST:
                    replaceFragment(new SecondFragment());
                    current = Stage.SECOND;
                    btnSwitch.setText("Next (Third Fragment)");
                    break;
                case SECOND:
                    replaceFragment(new ThirdFragment());
                    current = Stage.THIRD;
                    btnSwitch.setText("Next (First Fragment)");
                    break;
                case THIRD:
                    replaceFragment(new FirstFragment());
                    current = Stage.FIRST;
                    btnSwitch.setText("Next (Second Fragment)");
                    break;
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment);
        fragmentTransaction.commit();
    }
}