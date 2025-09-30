package com.example.listview;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private ListView mListProgrammingLanguage;
    private String[] mLanguages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupViews();
        setupListener();
    }

    private void setupListener(){
        AdapterView.OnItemClickListener listener = (parent, view, position, id) -> {
            String languageItem = mLanguages[position];
            Toast.makeText(
                    this, languageItem, Toast.LENGTH_LONG
            ).show();
        };
        mListProgrammingLanguage.setOnItemClickListener(listener);
    }

    private void setupViews(){
        mListProgrammingLanguage = findViewById(R.id.list_language);
        setupData();
        ArrayAdapter<String> languageAdapter = new ArrayAdapter<>(
                this, R.layout.item_language, mLanguages
        );
        mListProgrammingLanguage.setAdapter(languageAdapter);
        mListProgrammingLanguage.setDivider(
                AppCompatResources.getDrawable(this, R.drawable.list_divider)
        );
    }
    private void setupData(){
        mLanguages = getResources().getStringArray(R.array.programming_languages);
    }
}