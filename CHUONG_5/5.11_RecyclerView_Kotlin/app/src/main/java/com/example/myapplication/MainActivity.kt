package com.example.myapplication

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.LocalDataSource


class MainActivity : AppCompatActivity() {
    private lateinit var recyclerStudent: RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var viewModel: StudentViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupView()
        setupViewModel()
    }

    private fun setupView() {
        recyclerStudent = findViewById(R.id.rv_student)
        studentAdapter = StudentAdapter(object : StudentAdapter.OnStudentClickListener {
            override fun onClick(student: Student) {
                Toast.makeText(
                    this@MainActivity,
                    student.fullName.toString(),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }
        })
        recyclerStudent.adapter = studentAdapter
        val divider = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerStudent.addItemDecoration(divider)
    }

    private fun setupViewModel() {
        val dataSource = LocalDataSource(this)
        val viewModelFactory = StudentViewModel.Factory(dataSource)
        viewModel = ViewModelProvider(this, viewModelFactory)[StudentViewModel::class.java]
        viewModel.loadStudents()
        viewModel.students.observe(this) {
            studentAdapter.updateStudents(it)
        }
    }
}