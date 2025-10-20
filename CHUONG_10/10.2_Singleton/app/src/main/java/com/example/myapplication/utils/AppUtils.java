package com.example.myapplication.utils;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class AppUtils {
    public static final String DATE_FORMAT = "dd/MM/yyyy";

    private AppUtils(){}

    public static int getAvatar(String gender) {
        switch (gender.toLowerCase()){
            case "nam":
                return R.drawable.ic_man;
            case "nữ":
                return R.drawable.ic_woman;
        }
        return R.drawable.ic_woman;
    }

    public static String formatDate(Date birthDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        return dateFormat.format(birthDate);
    }
}
