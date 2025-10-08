package com.example.viewpager.ui.adapter;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.viewpager.data.model.Zodiac;
import com.example.viewpager.ui.fragment.ZodiacItemFragment;

import java.util.List;
import java.util.Objects;

public class ZodiacPagerAdapter extends FragmentStateAdapter {
    private List<Zodiac> zodiacList;

    public ZodiacPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment = new ZodiacItemFragment();
        Bundle args = new Bundle();

        if (zodiacList != null && position < zodiacList.size()) {
            Zodiac zodiac = zodiacList.get(position);
            if (zodiac != null && zodiac.getDrawableId() != null) {
                args.putInt(ZodiacItemFragment.BUNDLE_KEY_DRAWABLE_ID, zodiac.getDrawableId());
            }
        }

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getItemCount() {
        return zodiacList != null ? zodiacList.size() : 0;
    }

    public void submitList(List<Zodiac> newList) {
        zodiacList = newList;
        notifyDataSetChanged();
    }

    public Zodiac getZodiacAtPosition(int position) {
        if (zodiacList != null && position < zodiacList.size()) {
            return zodiacList.get(position);
        }
        return null;
    }
}