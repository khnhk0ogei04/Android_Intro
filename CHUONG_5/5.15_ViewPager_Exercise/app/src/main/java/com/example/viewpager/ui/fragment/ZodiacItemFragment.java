package com.example.viewpager.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.viewpager.R;
import com.example.viewpager.databinding.FragmentZodiacItemBinding;

public class ZodiacItemFragment extends Fragment {
    private FragmentZodiacItemBinding binding;
    public static final String BUNDLE_KEY_DRAWABLE_ID = "drawableId";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentZodiacItemBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadImage();
    }

    private void loadImage() {
        Bundle args = getArguments();
        if (args != null && args.containsKey(BUNDLE_KEY_DRAWABLE_ID)) {
            int drawableId = args.getInt(BUNDLE_KEY_DRAWABLE_ID);
            binding.image.setImageResource(drawableId);
        } else {
            binding.image.setImageResource(R.drawable.dragon);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}



