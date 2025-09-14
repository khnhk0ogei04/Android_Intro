package com.example.imageviewexercise

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textEmail: EditText;
    private lateinit var textPassword: EditText;
    private lateinit var imgShowPassword: ImageView;
    private lateinit var transformation: PasswordMaskTransformation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupViews()
        transformation = PasswordMaskTransformation()
        textPassword.transformationMethod = transformation
    }

    private fun setupViews(){
        textEmail = findViewById(R.id.edt_email)
        textPassword = findViewById(R.id.edt_password)
        imgShowPassword = findViewById(R.id.img_pwd)
        imgShowPassword.setOnClickListener {
            processPassword()
        }
    }

    private fun processPassword(){
        if (textPassword.transformationMethod.equals(transformation)){
            textPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            imgShowPassword.setImageResource(R.drawable.ic_hide_pwd_24)
        } else {
            textPassword.transformationMethod = transformation
            imgShowPassword.setImageResource(R.drawable.ic_show_password)
        }
    }
}