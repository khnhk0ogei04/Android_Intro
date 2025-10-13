package com.example.actionbar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.actionbar.R;
import com.example.actionbar.model.Student;
import com.example.actionbar.viewmodel.StudentViewModel;

public class EditFragment extends Fragment implements View.OnFocusChangeListener{
    private EditText editTextFullName;
    private Toolbar toolbar;
    private EditText editTextAge;
    private StudentViewModel viewModel;
    private boolean isEditing = false;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit, container, false);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.student_detail_menu, menu);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        toolbar = view.findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.student_detail_menu);
        toolbar.setTitle(getString(R.string.text_editing));
        updateToolbar();
        editTextFullName = view.findViewById(R.id.edit_full_name);
        editTextAge = view.findViewById(R.id.edit_age);
        editTextFullName.setOnFocusChangeListener(this::onFocusChange);
        editTextAge.setOnFocusChangeListener(this);
        viewModel = new ViewModelProvider(requireActivity()).get(StudentViewModel.class);
        viewModel.getStudent().observe(getViewLifecycleOwner(), this::showDetail);
        toolbar.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.action_done) {
                onClick();
                return true;
            }
            return false;
        });
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24);
        toolbar.setNavigationOnClickListener(v -> requireActivity().onBackPressed());
    }

    public void onClick() {
        Student student = new Student(
                editTextFullName.getText().toString(),
                Integer.parseInt(editTextAge.getText().toString())
        );
        viewModel.setStudent(student);
        requireActivity().onBackPressed();
    }
    private void showDetail(Student student) {
        editTextFullName.setText(student.getFullName());
        editTextAge.setText(String.valueOf(student.getAge()));
    }

    private void updateToolbar() {
        MenuItem item = toolbar.getMenu().findItem(R.id.action_done);
        item.setVisible(isEditing);
    }

    @Override
    public void onFocusChange (View v, boolean hasFocus) {
        if (hasFocus) {
            isEditing = true;
            updateToolbar();
        }
    }
}