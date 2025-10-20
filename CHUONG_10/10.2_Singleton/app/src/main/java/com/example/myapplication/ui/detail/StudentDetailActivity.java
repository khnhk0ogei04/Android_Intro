package com.example.myapplication.ui.detail;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.data.model.Student;
import com.example.myapplication.databinding.ActivityStudentDetailBinding;
import com.example.myapplication.utils.AppUtils;

public class StudentDetailActivity extends AppCompatActivity {
    public static final String EXTRA_STUDENT_ID = "student_id";
    private ActivityStudentDetailBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        mBinding = ActivityStudentDetailBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        setupViewModel();
    }

    private void setupViewModel(){
        StudentDetailViewModel viewModel = new ViewModelProvider(this).get(StudentDetailViewModel.class);
        String studentId = getIntent().getStringExtra(EXTRA_STUDENT_ID);
        if (studentId != null) {
            viewModel.loadStudent(studentId);
        }
        viewModel.getStudent().observe(this, this::showStudentInfo);
    }

    private void showStudentInfo(Student student) {
        String birthDateStr = AppUtils.formatDate(student.getmBirthDate());
        mBinding.imageDetailAvatar.setImageResource(AppUtils.getAvatar(student.getmGender()));
        mBinding.textDetailId.setText(getString(R.string.id, student.getmId()));
        mBinding.textDetailFullName.setText(getString(R.string.full_name, student.getmFullName()));
        mBinding.textDetailGpa.setText(getString(R.string.gpa, student.getmGpa()));
        mBinding.textDetailYear.setText(getString(R.string.year, student.getmYear()));
        mBinding.textDetailGender.setText(getString(R.string.gender, student.getmGender()));
        mBinding.textDetailEmail.setText(getString(R.string.email, student.getmEmail()));
        mBinding.textDetailAddress.setText(getString(R.string.address, student.getmAddress()));
        mBinding.textDetailMajor.setText(getString(R.string.major, student.getmMajor()));
        mBinding.textDetailBirthDate.setText(getString(R.string.birth_date, birthDateStr));
    }
}