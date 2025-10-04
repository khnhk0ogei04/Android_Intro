package com.example.gridview.utils;

import com.example.gridview.R;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public abstract class CountryUtils {
    private static final Map<String, Integer> idsOfFlag = new HashMap<>();
    static {
        idsOfFlag.put("bangladesh.png", R.drawable.bangladesh);
        idsOfFlag.put("brazil.png", R.drawable.brazil);
        idsOfFlag.put("china.png", R.drawable.china);
        idsOfFlag.put("india.png", R.drawable.india);
        idsOfFlag.put("dr_congo.png", R.drawable.dr_congo);
        idsOfFlag.put("egypt.png", R.drawable.egypt);
        idsOfFlag.put("ethiopia.png", R.drawable.ethiopia);
        idsOfFlag.put("indonesia.png", R.drawable.indonesia);
        idsOfFlag.put("japan.png", R.drawable.japan);
        idsOfFlag.put("mexico.png", R.drawable.mexico);
        idsOfFlag.put("nigeria.png", R.drawable.nigeria);
        idsOfFlag.put("pakistan.png", R.drawable.pakistan);
        idsOfFlag.put("philippines.png", R.drawable.philippines);
        idsOfFlag.put("russia.png", R.drawable.russia);
        idsOfFlag.put("united_states.png", R.drawable.united_states);
        idsOfFlag.put("vietnam.png", R.drawable.vietnam);
    }

    public static String formatNumber(float number) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.#");
        return decimalFormat.format(number);
    }

    public static int findFlagId(String flagName){
        int id;
        try {
            id = Objects.requireNonNull(idsOfFlag.get(flagName));
        } catch (NullPointerException ignored) {
            id = -1;
        }
        return id;
    }
}
