package com.example.fragment;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.fragment.ui.fragment.CountryDetailFragment;
import com.example.fragment.ui.viewmodel.SharedCountryItemViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupViewModel();
    }

    private void showDetail() {
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.anim.slide_in, // enter
                        R.anim.fade_out, // exit
                        R.anim.fade_in, // popEnter
                        R.anim.slide_out // popExit
                )
                .replace(R.id.fragment_container, CountryDetailFragment.class, null)
                .addToBackStack(null)
                .commit();
    }

    private void setupViewModel() {
        SharedCountryItemViewModel sharedViewModel = new ViewModelProvider(this).get(SharedCountryItemViewModel.class);
        sharedViewModel.selectedCountry.observe(this, country -> showDetail());
    }
}