package com.example.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var mListProgrammingLanguage: ListView
    private lateinit var mLanguages: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        setupViews()
        setupListener()
    }

    private fun setupData(){
        mLanguages = resources.getStringArray(R.array.programming_languages)
    }

    private fun setupViews(){
        mListProgrammingLanguage = findViewById(R.id.list_language)
        setupData()
        val languageAdapter = ArrayAdapter(
            this, R.layout.item_language, mLanguages
        )
        mListProgrammingLanguage.adapter = languageAdapter
        mListProgrammingLanguage.divider = AppCompatResources.getDrawable(this, R.drawable.list_divider)
    }

    private fun setupListener(){
        val listener = AdapterView.OnItemClickListener{_, _, position, _ ->
            val languageItem = mLanguages[position]
            Toast.makeText(this, languageItem, Toast.LENGTH_LONG).show()
        }
        mListProgrammingLanguage.onItemClickListener = listener
    }

}