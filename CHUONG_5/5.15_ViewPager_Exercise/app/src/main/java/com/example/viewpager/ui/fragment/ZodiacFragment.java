package com.example.viewpager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpager.data.datasource.ZodiacLocalDataSourceImpl;
import com.example.viewpager.data.model.Zodiac;
import com.example.viewpager.databinding.FragmentZodiacBinding;
import com.example.viewpager.ui.adapter.ZodiacPagerAdapter;
import com.google.android.material.tabs.TabLayoutMediator;

public class ZodiacFragment extends Fragment {
    private FragmentZodiacBinding binding;
    private ZodiacPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentZodiacBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupViewPager();
    }

    private void setupViewPager() {
        ZodiacLocalDataSourceImpl dataSource = new ZodiacLocalDataSourceImpl();
        adapter = new ZodiacPagerAdapter(this);
        adapter.submitList(dataSource.getZodiacs());
        binding.viewPager.setAdapter(adapter);
        new TabLayoutMediator(binding.tabLayout, binding.viewPager,
                (tab, position) -> {
                    Zodiac zodiac = adapter.getZodiacAtPosition(position);
                    if (zodiac != null) {
                        tab.setText(zodiac.getName());
                    }
                }).attach();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
