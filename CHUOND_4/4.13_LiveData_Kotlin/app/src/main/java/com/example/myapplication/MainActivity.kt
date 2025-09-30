package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var txtNewName: TextView
    private lateinit var nameViewModel: NameViewModel
    private lateinit var edtFullName: TextInputEditText
    private lateinit var btnChangeName: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupViews()
        setupAction()
        setupViewModel()
    }

    private fun setupAction(){
        btnChangeName.setOnClickListener {
            val fullName = edtFullName.text.toString().trim()
            nameViewModel.updateName(fullName)
        }
    }

    private fun setupViews(){
        edtFullName = findViewById(R.id.edt_full_name)
        txtNewName = findViewById(R.id.txt_new_name)
        btnChangeName = findViewById(R.id.btn_change)
    }

    private fun setupViewModel(){
        nameViewModel = ViewModelProvider(this)[NameViewModel::class.java]
        nameViewModel.currentName.observe(this){
            fullName -> txtNewName.text = getString(R.string.text_result, fullName)
        }
    }
}