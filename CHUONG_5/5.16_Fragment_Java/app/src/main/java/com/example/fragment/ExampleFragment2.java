package com.example.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ExampleFragment2 extends Fragment {
    private static final String ARG_ITEM_MESSAGE = "ARG_ITEM_MESSAGE";
    private static final String ARG_ITEM_SALARY = "param2";

    private String mMessage;
    private float mSalary;

    public ExampleFragment2() {

    }

    // TODO: Rename and change types and number of parameters
    public static ExampleFragment2 newInstance(String param1, float salary) {
        ExampleFragment2 fragment = new ExampleFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM_MESSAGE, param1);
        args.putFloat(ARG_ITEM_SALARY, salary);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mMessage = getArguments().getString(ARG_ITEM_MESSAGE);
            mSalary = getArguments().getFloat(ARG_ITEM_SALARY, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_example2, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        TextView textInfo = requireActivity().findViewById(R.id.text_info_fragment2);
        textInfo.setText(mMessage + ", Salary: " + mSalary);
    }
}