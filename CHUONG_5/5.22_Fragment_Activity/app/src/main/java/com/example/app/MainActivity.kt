package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), OnDataSentListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val inputFragment = InputFragment()
        inputFragment.setOnDataSentListener(this)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer, inputFragment)
            .commit()
    }

    override fun onDataSent(data: String) {
        Toast.makeText(
            this, "Received ${data}", Toast.LENGTH_SHORT
        ).show()
    }
}