package com.example.learnpassword01

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var buttonLogin: Button;
    private lateinit var buttonRegister: Button;
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupViews()
    }

    private fun setupViews(){
        buttonLogin = findViewById(R.id.btn_login)
        buttonRegister = findViewById(R.id.btn_register)
        editEmail = findViewById(R.id.edit_email)
        editPassword = findViewById(R.id.edit_password)
        editPassword.transformationMethod = PasswordTransformationMethod()
        buttonLogin.setOnClickListener(this)
        buttonRegister.setOnClickListener(this)
    }

    private fun checkLogin(){
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        var loginAccount = Account(email, password)
        if (loginAccount.equals(defaultAccount)){
            Toast.makeText(this,
                getString(R.string.message_login_success, email),
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                this,
                getString(R.string.message_login_failed),
                Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun onClick(v: View?) {
        v?.let {
            if (v.id === R.id.btn_register) {
                val message = "Register Successfully!\n Your account ${editEmail.text} is activated!"
                Toast.makeText(this, message, Toast.LENGTH_LONG).show()
            } else if (v.id === R.id.btn_login) {
                checkLogin()
            }
        }
    }

    companion object {
        val defaultAccount = Account("admin@gmail.com", "123456")

    }
}