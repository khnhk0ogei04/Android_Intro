package com.example.framelayout

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val textViewMessage = findViewById<TextView>(R.id.textViewMessage)
        val buttonToggle = findViewById<Button>(R.id.buttonToggle)

        buttonToggle.setOnClickListener {
            if (textViewMessage.visibility == View.VISIBLE){
                textViewMessage.visibility = View.GONE
                buttonToggle.text = "Show Message"
            } else {
                textViewMessage.visibility = View.VISIBLE
                buttonToggle.text = "Hide Message"
            }
        }
    }
}