package com.example.myapplication.ui;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.R;
import com.example.myapplication.data.Country;
import com.example.myapplication.data.CountryRepository;
import com.example.myapplication.data.LocalDataSource;

public class MainActivity extends AppCompatActivity {
    private CountryAdapter mCountryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupViews();
        observeData();
    }

    private void observeData(){
        LocalDataSource localDataSource = new LocalDataSource(getResources());
        CountryRepository repository = new CountryRepository(localDataSource);
        CountryViewModel.Factory factory = new CountryViewModel.Factory(repository);
        CountryViewModel mViewModel =
                new ViewModelProvider(this, factory).get(CountryViewModel.class);
        mViewModel.loadCountries();
        mViewModel.getCountries().observe(this, mCountryAdapter::updateCountries);
    }

    private void setupViews(){
        ListView listCountry = findViewById(R.id.list_country);
        mCountryAdapter = new CountryAdapter();
        listCountry.setAdapter(mCountryAdapter);
        listCountry.setDivider(AppCompatResources.getDrawable(this, R.drawable.divider));
        listCountry.setOnItemClickListener((parent, view, position, id) -> {
            Country country = (Country) parent.getItemAtPosition(position);
            Toast.makeText(MainActivity.this, "Choose country: " + country.getName(), Toast.LENGTH_SHORT).show();
        });
    }
}