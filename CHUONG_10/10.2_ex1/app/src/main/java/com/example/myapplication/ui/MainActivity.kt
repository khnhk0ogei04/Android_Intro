package com.example.myapplication.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Country
import com.example.myapplication.data.LocalDataSource
import com.example.myapplication.ui.detail.CountryDetailActivity

class MainActivity : AppCompatActivity() {
    private lateinit var countryAdapter: CountryAdapter
    private lateinit var countryRecyclerView: RecyclerView
    private lateinit var countryViewModel: CountryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        countryRecyclerView = findViewById(R.id.recycler_country)
        countryAdapter = CountryAdapter(object : CountryAdapter.OnItemClickListener {
            override fun onClick(country: Country) {
                navigateToCountryDetail(country)
            }
        })
        countryRecyclerView.adapter = countryAdapter
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        countryRecyclerView.addItemDecoration(divider)
    }

    private fun navigateToCountryDetail(country: Country){
        Intent(this, CountryDetailActivity::class.java).apply {
            putExtra(CountryDetailActivity.EXTRA_COUNTRY_NAME, country.name)
            startActivity(this)
        }
    }

    private fun setupViewModel() {
        val dataSource = LocalDataSource.getInstance(resources)
        val factory = CountryViewModel.Factory(dataSource)
        countryViewModel = ViewModelProvider(this, factory)[CountryViewModel::class.java]
        countryViewModel.loadCountries()
        countryViewModel.countries.observe(this) { countries ->
            countryAdapter.submitData(countries)
        }
    }
}