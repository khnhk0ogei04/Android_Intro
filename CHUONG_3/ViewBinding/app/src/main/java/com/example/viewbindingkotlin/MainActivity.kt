package com.example.viewbindingkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.viewbindingkotlin.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        setupView()
    }

    private fun setupView(){
        val btnSubmit = binding.btnSubmit
        btnSubmit.setOnClickListener {
            val message = binding.textMessage.text.toString()
            Snackbar.make(
                binding.root,
                message,
                Snackbar.LENGTH_LONG
            ).show()
        }
    }
}