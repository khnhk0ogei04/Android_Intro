package com.example.learntextinputlayout

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var editTextEmail: TextInputEditText
    private lateinit var editTextPassword: TextInputEditText
    private lateinit var textInputLayoutPassword: TextInputLayout
    private lateinit var btnLogin: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupView()
    }

    private fun setupView(){
        editTextEmail = findViewById(R.id.edt_email)
        editTextPassword = findViewById(R.id.edt_password)
        btnLogin = findViewById(R.id.btn_login)
        textInputLayoutPassword = findViewById(R.id.til_password)
        editTextPassword.transformationMethod = PasswordMask.getInstance()
        textInputLayoutPassword.addEndIconOnClickListener()
        btnLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()
            val message = "Welcome $email!\nYour password: $password"
            val view = findViewById<ConstraintLayout>(R.id.main)
            Snackbar.make(
                view,
                message, Snackbar.LENGTH_LONG
            ).show()
        }
    }

}