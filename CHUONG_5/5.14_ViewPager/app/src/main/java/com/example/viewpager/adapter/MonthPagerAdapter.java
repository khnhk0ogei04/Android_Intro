package com.example.viewpager.adapter;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpager.R;
import com.example.viewpager.fragment.MonthObjectFragment;

public class MonthPagerAdapter extends FragmentStateAdapter {
    private String[] data;

    public MonthPagerAdapter(@NonNull Fragment fm) {
        super(fm);
    }

    public MonthPagerAdapter(@NonNull Context context, @NonNull Fragment fm){
        this(fm);
        data = context.getResources().getStringArray(R.array.array_month);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new MonthObjectFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MonthObjectFragment.BUNDLE_KEY, data[position]);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return data.length;
    }
}
