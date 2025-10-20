package com.example.myapplication.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.R
import com.example.myapplication.data.LocalDataSource
import com.example.myapplication.utils.CountryUtils

class CountryDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: CountryDetailViewModel
    private lateinit var textCountryName: TextView
    private lateinit var textCapital: TextView
    private lateinit var textPopulation: TextView
    private lateinit var textArea: TextView
    private lateinit var textDensity: TextView
    private lateinit var textWorldShare: TextView
    private lateinit var imageFlag: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_country_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        imageFlag = findViewById(R.id.image_flag_detail)
        textCountryName = findViewById(R.id.text_nation_detail)
        textCapital = findViewById(R.id.text_capital_detail)
        textPopulation = findViewById(R.id.text_population_detail)
        textArea = findViewById(R.id.text_area_detail)
        textDensity = findViewById(R.id.text_density_detail)
        textWorldShare = findViewById(R.id.text_world_share_detail)
    }

    private fun setupViewModel() {
        // todo 4 done: sử dụng đối tượng LocalDataSource singleton
        val dataSource = LocalDataSource.getInstance(resources)
        val factory = CountryDetailViewModel.Factory(dataSource)
        viewModel = ViewModelProvider(this, factory)[CountryDetailViewModel::class.java]
        val countryName = intent.getStringExtra(EXTRA_COUNTRY_NAME)
        if (countryName != null) {
            viewModel.getCountryByName(countryName)
        }
        viewModel.country.observe(this) { country ->
            imageFlag.setImageResource(CountryUtils.getDrawableResource(country.flag))
            textCountryName.text = getString(R.string.text_nation, country.name)
            textCapital.text = getString(R.string.text_capital, country.capital)
            textPopulation.text = getString(R.string.text_population, country.population)
            textArea.text = getString(R.string.text_area, country.area)
            textDensity.text = getString(R.string.text_density, country.density)
            textWorldShare.text = getString(R.string.text_world_share, country.worldShare)
        }
    }

    companion object {
        const val EXTRA_COUNTRY_NAME = "country_name"
    }
}