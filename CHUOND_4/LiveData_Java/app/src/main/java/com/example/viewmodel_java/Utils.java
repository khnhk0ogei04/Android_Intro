package com.example.viewmodel_java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Utils {
    private static final String format = "dd/MM/yyyy";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(format);
    public static Date stringToDate(String dateStr){
        try {
            return dateFormat.parse(dateStr);
        } catch (ParseException ignored){
            return null;
        }
    }

    public static String dateToString(Date date){
        if (date == null){
            return "";
        }
        return dateFormat.format(date);
    }
}
