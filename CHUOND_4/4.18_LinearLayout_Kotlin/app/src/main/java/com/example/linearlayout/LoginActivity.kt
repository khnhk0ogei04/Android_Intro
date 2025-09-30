package com.example.linearlayout

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val textViewResult = findViewById<TextView>(R.id.textViewResult)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            when {
                username.isEmpty() || password.isEmpty() -> {
                    textViewResult.text = "Please fill in all fields."
                    Toast.makeText(this, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
                }
                username == "admin" && password == "123456" -> {
                    textViewResult.text = "Login successful! Welcome, $username!"
                    Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    textViewResult.text = "Invalid username or password."
                    Toast.makeText(this, "Invalid username or password.", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}