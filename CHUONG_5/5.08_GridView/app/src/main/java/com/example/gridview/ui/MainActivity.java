package com.example.gridview.ui;

import android.os.Bundle;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.gridview.R;
import com.example.gridview.data.source.CountryDataRepository;
import com.example.gridview.data.source.CountryDataSource;
import com.example.gridview.data.source.local.LocalDataSource;
import com.example.gridview.ui.adapter.CountryAdapter;
import com.example.gridview.ui.viewmodel.CountryViewModel;
import com.example.gridview.ui.viewmodel.CountryViewModelFactory;

public class MainActivity extends AppCompatActivity {
    private CountryAdapter mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        setupViews();
        setupViewModel();
    }

    private void setupViews(){
        GridView mGridCountry = findViewById(R.id.grid_country);
        mCountryAdapter = new CountryAdapter(null);
        mGridCountry.setAdapter(mCountryAdapter);
    }

    private void setupViewModel(){
        CountryDataSource dataSource = new LocalDataSource(this);
        CountryDataRepository repository = new CountryDataRepository(dataSource);
        CountryViewModel viewModel = new ViewModelProvider(
                this, new CountryViewModelFactory(repository)
        ).get(CountryViewModel.class);
        viewModel.country.observe(this, mCountryAdapter::updateData);
    }
}