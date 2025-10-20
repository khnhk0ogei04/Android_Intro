package com.example.myapplication.ui;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.data.model.Student;
import com.example.myapplication.databinding.ItemStudentBinding;
import com.example.myapplication.utils.AppUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder>{
    private final List<Student> mStudents = new ArrayList<>();
    private final OnClickListener mListener;

    public StudentAdapter(OnClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemStudentBinding binding = ItemStudentBinding.inflate(layoutInflater, parent, false);
        return new StudentViewHolder(binding, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        holder.bind(mStudents.get(position));
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public void updateStudents(List<Student> students) {
        int oldSize = mStudents.size();
        mStudents.clear();
        mStudents.addAll(students);
        notifyItemRangeRemoved(0, oldSize);
        notifyItemRangeInserted(0, students.size());
    }

    public interface OnClickListener {
        void onClick(Student student);
    }

    public static class StudentViewHolder extends RecyclerView.ViewHolder {
        private final ItemStudentBinding mBinding;
        private final OnClickListener mListener;
        public StudentViewHolder(ItemStudentBinding binding, OnClickListener listener) {
            super(binding.getRoot());
            mBinding = binding;
            mListener = listener;
        }
        public void bind(Student student){
            mBinding.textStudentId.setText(student.getmId());
            mBinding.textFullName.setText(student.getmFullName().toString());
            mBinding.textGpa.setText(student.getmGender());
            mBinding.imageAvatar.setImageResource(AppUtils.getAvatar(student.getmGender()));
            mBinding.getRoot().setOnClickListener(v -> mListener.onClick(student));
        }
    }
}
