package com.example.myapplication.utils;

import com.example.myapplication.R;

public abstract class StudentUtils {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    public static int findDrawableRes(String gender){
        String result = gender.toLowerCase().trim();
        if (gender.compareTo("nam") == 0){
            return R.drawable.ic_man;
        } else {
            return R.drawable.ic_woman;
        }
    }
}