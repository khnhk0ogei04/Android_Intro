package com.example.fragment.data.repository;

import android.content.Context;

import com.example.fragment.R;

import java.text.DecimalFormat;

public class Utils {
    public static final String EXTRA_COUNTRY_INDEX = "EXTRA_COUNTRY_INDEX";

    public static int getDrawableId(Context context, String drawableName) {
        int id = context.getResources().getIdentifier(
                drawableName.replace(".png", "").replace(".jpg", ""),
                "drawable",
                context.getPackageName()
        );
        return id != 0 ? id : R.drawable.vietnam;
    }

    public static String getNumberFormatted(float number){
        DecimalFormat formatter = new DecimalFormat("#,###.#");
        return formatter.format(number);
    }
}
