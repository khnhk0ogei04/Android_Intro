package com.example.myapplication.ui.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.data.source.StudentDataRepository;

public class StudentViewModelFactory implements ViewModelProvider.Factory {
    private final StudentDataRepository mRepository;

    public StudentViewModelFactory(StudentDataRepository repository) {
        mRepository = repository;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(StudentViewModel.class)) {
            return (T) new StudentViewModel(mRepository);
        } else {
            throw new IllegalArgumentException("Argument is not class StudentViewModel.");
        }
    }
}