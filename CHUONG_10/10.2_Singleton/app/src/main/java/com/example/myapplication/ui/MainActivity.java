package com.example.myapplication.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.ui.detail.StudentDetailActivity;
import com.example.myapplication.ui.detail.StudentDetailViewModel;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private StudentAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setupView();
        setupObserver();
    }
    private void setupView(){
        mAdapter = new StudentAdapter(student -> {
            Intent intent = new Intent(MainActivity.this, StudentDetailActivity.class);
            intent.putExtra(StudentDetailActivity.EXTRA_STUDENT_ID, student.getmId());
            startActivity(intent);
        });
        mBinding.rvStudent.setAdapter(mAdapter);
        DividerItemDecoration divider = new DividerItemDecoration(this, RecyclerView.VERTICAL);
        mBinding.rvStudent.addItemDecoration(divider);
    }

    private void setupObserver(){
        StudentViewModel mViewModel = new ViewModelProvider(this)
                .get(StudentViewModel.class);
        mViewModel.getStudents().observe(this, students -> {
            if (students != null) {
                mAdapter.updateStudents(students);
            }
        });
        // MainActivityBinding.getRoot
        mViewModel.getErrorMessage().observe(this, message -> {
            if (message != null) {
                Snackbar.make(mBinding.getRoot(), message, Snackbar.LENGTH_LONG).show();
            }
        });
        mViewModel.loadStudents();
    }
}