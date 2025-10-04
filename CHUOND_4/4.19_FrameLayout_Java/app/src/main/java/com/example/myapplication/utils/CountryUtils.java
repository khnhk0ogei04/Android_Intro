package com.example.myapplication.utils;

import com.example.myapplication.R;

import java.util.HashMap;
import java.util.Map;

public abstract class CountryUtils {
    private static final Map<String, Integer> idOfFlags = new HashMap<>();
    static {
        idOfFlags.put("vietnam", R.drawable.vietnam);
        idOfFlags.put("brazil", R.drawable.brazil);
        idOfFlags.put("china", R.drawable.china);
        idOfFlags.put("india", R.drawable.india);
        idOfFlags.put("indonesia", R.drawable.indonesia);
        idOfFlags.put("pakistan", R.drawable.pakistan);
        idOfFlags.put("nigeria", R.drawable.nigeria);
        idOfFlags.put("bangladesh", R.drawable.bangladesh);
        idOfFlags.put("russia", R.drawable.russia);
        idOfFlags.put("mexico", R.drawable.mexico);
        idOfFlags.put("ethiopia", R.drawable.ethiopia);
        idOfFlags.put("japan", R.drawable.japan);
        idOfFlags.put("philippines", R.drawable.philippines);
        idOfFlags.put("egypt", R.drawable.egypt);
        idOfFlags.put("dr_congo", R.drawable.dr_congo);
        idOfFlags.put("united_states", R.drawable.united_states);
    }

    public static int getFlagResId(String flag){
        int index = flag.indexOf(".");
        Integer resId = idOfFlags.get(flag.substring(0, index));
        return resId == null ? R.drawable.vietnam : resId;
    }
}
