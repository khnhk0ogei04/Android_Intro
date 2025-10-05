package com.example.myapplication.ui.adapter;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.model.Student;
import com.example.myapplication.utils.StudentUtils;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    private final List<Student> mStudents;
    private final OnItemClickListener mListener;

    public StudentAdapter(List<Student> students, OnItemClickListener listener) {
        if (students == null) {
            mStudents = new ArrayList<>();
        } else {
            mStudents = students;
        }
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = mStudents.get(position);
        holder.bindData(student);
    }

    @Override
    public int getItemCount() {
        return mStudents.size();
    }

    public void updateData(List<Student> students) {
        mStudents.clear();
        mStudents.addAll(students);
        notifyItemRangeInserted(0, mStudents.size());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final View mItemView;
        private ImageView mImageAvatar;
        private TextView mTextStudentId;
        private TextView mTextFullName;
        private TextView mTextGpa;
        private final OnItemClickListener mListener;

        public ViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            mItemView = itemView;
            mListener = listener;
            initViews();
        }

        public void bindData(Student student) {
            mTextStudentId.setText(student.getStudentId());
            mTextFullName.setText(student.getFullName());
            mTextGpa.setText(String.valueOf(student.getGpa()));
            Glide.with(mImageAvatar)
                    .load(StudentUtils.findDrawableRes(student.getGender()))
                    .error(R.drawable.ic_man)
                    .into(mImageAvatar);
            mItemView.setOnClickListener(v -> mListener.onItemClick(student));
        }

        private void initViews() {
            mImageAvatar = mItemView.findViewById(R.id.image_avatar);
            mTextFullName = mItemView.findViewById(R.id.text_full_name);
            mTextGpa = mItemView.findViewById(R.id.text_gpa);
            mTextStudentId = mItemView.findViewById(R.id.text_student_id);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Student student);
    }
}

