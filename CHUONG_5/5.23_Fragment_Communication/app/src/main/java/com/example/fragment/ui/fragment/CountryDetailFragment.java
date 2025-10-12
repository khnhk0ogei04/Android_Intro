package com.example.fragment.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.fragment.R;
import com.example.fragment.data.model.Country;
import com.example.fragment.data.repository.Utils;
import com.example.fragment.ui.viewmodel.SharedCountryItemViewModel;

public class CountryDetailFragment extends Fragment {
    private ImageView imageFlag;
    private TextView textCountry;
    private TextView textCapital;
    private TextView textPopulation;
    private TextView textArea;
    private TextView textDensity;
    private TextView textWorldShare;

    public CountryDetailFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_country_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();
        new ViewModelProvider(requireActivity()).get(SharedCountryItemViewModel.class)
                .selectedCountry.observe(getViewLifecycleOwner(), this::showDetail);
    }

    private void initViews() {
        imageFlag = requireActivity().findViewById(R.id.image_flag_detail);
        textCountry = requireActivity().findViewById(R.id.text_nation_detail);
        textCapital = requireActivity().findViewById(R.id.text_capital_detail);
        textPopulation = requireActivity().findViewById(R.id.text_population_detail);
        textArea = requireActivity().findViewById(R.id.text_area_detail);
        textDensity = requireActivity().findViewById(R.id.text_density_detail);
        textWorldShare = requireActivity().findViewById(R.id.text_world_share_detail);
        ImageView imageBack = requireActivity().findViewById(R.id.image_back);
        imageBack.setOnClickListener(v -> requireActivity()
                .getOnBackPressedDispatcher()
                .onBackPressed()
        );
    }

    private void showDetail(Country country) {
        String countryStr = getString(R.string.text_nation) + " " + country.getName();
        String capitalStr = getString(R.string.text_capital) + " " + country.getCapital();
        String popStr = getString(R.string.text_population) + " " +
                Utils.getNumberFormatted(country.getPopulation()) +
                " " + getString(R.string.text_million);
        String areaStr = getString(R.string.text_area) + " " +
                Utils.getNumberFormatted(country.getArea())
                + " " + getString(R.string.text_km2);
        String densityStr = getString(R.string.text_density) + " " +
                Utils.getNumberFormatted(country.getDensity()) +
                " " + getString(R.string.text_ppa);
        String worldShareStr = getString(R.string.text_world_share) +
                " " + country.getWorldShare();
        textCountry.setText(countryStr);
        textCapital.setText(capitalStr);
        textPopulation.setText(popStr);
        textArea.setText(areaStr);
        textDensity.setText(densityStr);
        textWorldShare.setText(worldShareStr);
        Glide.with(this)
                .load(Utils.getDrawableId(requireContext(), country.getFlag()))
                .into(imageFlag);
    }
}
