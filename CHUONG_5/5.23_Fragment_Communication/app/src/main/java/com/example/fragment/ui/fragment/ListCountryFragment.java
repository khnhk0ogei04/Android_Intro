package com.example.fragment.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragment.R;
import com.example.fragment.data.repository.CountryRepository;
import com.example.fragment.data.repository.CountryRepositoryImpl;
import com.example.fragment.ui.adapter.CountryAdapter;
import com.example.fragment.ui.viewmodel.CountryViewModel;
import com.example.fragment.ui.viewmodel.CountryViewModelFactory;
import com.example.fragment.ui.viewmodel.SharedCountryItemViewModel;

public class ListCountryFragment extends Fragment {
    private SharedCountryItemViewModel sharedViewModel;
    private CountryAdapter adapter;
    public ListCountryFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.fragment_list_country, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addRecyclerView();
        addViewModel();
    }

    private void addViewModel(){
        sharedViewModel = new ViewModelProvider(requireActivity())
                .get(SharedCountryItemViewModel.class);
        CountryRepository repository = new CountryRepositoryImpl(requireContext());
        CountryViewModel model = new ViewModelProvider(
                requireActivity(),
                new CountryViewModelFactory(repository)
        ).get(CountryViewModel.class);
        model.country.observe(getViewLifecycleOwner(), adapter::setCountries);
    }

    private void addRecyclerView(){
        RecyclerView recyclerViewCountry = requireActivity().findViewById(R.id.recycler_country);
        adapter = new CountryAdapter(
                requireContext(),
                country -> sharedViewModel.setSelectedCountry(country)
        );
        recyclerViewCountry.setAdapter(adapter);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        recyclerViewCountry.addItemDecoration(itemDecoration);
        recyclerViewCountry.setHasFixedSize(true);
    }
}
