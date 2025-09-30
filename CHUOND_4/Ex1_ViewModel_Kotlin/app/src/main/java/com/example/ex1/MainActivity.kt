package com.example.ex1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import com.example.ex1.databinding.ActivityMainBinding
import kotlin.time.Duration

class MainActivity : AppCompatActivity() {
    private val viewModel: FullNameViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViewModel()
        setupView()
    }

    private fun setupViewModel() {
        viewModel.fullName.observe(this){
            binding.tvFullName.text = getString(R.string.full_name, it)
        }
    }

    private fun setupView() {
        binding.btnSubmit.setOnClickListener {
            viewModel.setCurrentFullName(binding.etFullName.text.toString())
            Toast.makeText(this, binding.tvFullName.text.toString(), Toast.LENGTH_LONG).show()
        }
    }
}