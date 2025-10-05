package com.example.myapplication.ui;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.data.source.StudentDataRepository;
import com.example.myapplication.data.source.local.LocalDataSource;
import com.example.myapplication.ui.adapter.StudentAdapter;
import com.example.myapplication.ui.viewmodel.StudentViewModel;
import com.example.myapplication.ui.viewmodel.StudentViewModelFactory;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private StudentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupViews();
        setupViewModel();
    }

    private void setupViews() {
        RecyclerView recyclerView = findViewById(R.id.recycler_student);
        StudentAdapter.OnItemClickListener callback = student -> {
            String message = getString(R.string.message_info, student.getFullName());
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        };
        mAdapter = new StudentAdapter(null, callback);
        recyclerView.setAdapter(mAdapter);
        DividerItemDecoration divider =
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        Drawable drawableDivider = Objects.requireNonNull(
                AppCompatResources.getDrawable(this, R.drawable.list_divider));
        divider.setDrawable(drawableDivider);
        recyclerView.addItemDecoration(divider);
    }

    private void setupViewModel() {
        LocalDataSource localDataSource = new LocalDataSource(this);
        StudentDataRepository repository = new StudentDataRepository(localDataSource);
        StudentViewModel viewModel = new ViewModelProvider(
                this, new StudentViewModelFactory(repository)).get(StudentViewModel.class);
        viewModel.student.observe(this, mAdapter::updateData);
    }
}
