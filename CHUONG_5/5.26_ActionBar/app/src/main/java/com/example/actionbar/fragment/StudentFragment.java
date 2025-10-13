package com.example.actionbar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.actionbar.R;
import com.example.actionbar.model.Student;
import com.example.actionbar.viewmodel.StudentViewModel;


public class StudentFragment extends Fragment {
    private TextView textViewFullName;
    private TextView textViewAge;

    private final OnStudentEditListener listener;

    public StudentFragment(OnStudentEditListener listener) {
        this.listener = listener;
    }

    public static StudentFragment getInstance(OnStudentEditListener listener){
        return new StudentFragment(listener);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_student, container, false);
        textViewAge = view.findViewById(R.id.text_age);
        textViewFullName = view.findViewById(R.id.text_full_name);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.student_toolbar);
        toolbar.inflateMenu(R.menu.student_menu);
        toolbar.setTitle(getString(R.string.app_name));
        toolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.action_edit) {
                listener.onClick();
                return true;
            } else if (id == R.id.action_search) {
                return true;
            } else if (id == R.id.action_setting) {
                return true;
            }
            return false;
        });
        new ViewModelProvider(requireActivity()).get(StudentViewModel.class).getStudent()
                .observe(getViewLifecycleOwner(), this::showData);
    }

    private void showData(Student student){
        textViewFullName.setText(getString(R.string.text_lable_full_name) + " " + student.getFullName());
        textViewAge.setText(getString(R.string.text_label_age) + " " + student.getAge());
    }

    public interface OnStudentEditListener {
        void onClick();
    }
}