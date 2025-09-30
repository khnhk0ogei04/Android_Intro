package com.example.kotlin

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity: AppCompatActivity() {
    private val tasks = mutableListOf<String>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val listViewTasks = findViewById<ListView>(R.id.listViewTasks)
        adapter = TaskAdapter(this, tasks)
        listViewTasks.adapter = adapter

        buttonAdd.setOnClickListener {
            val task = editTextInput.text.toString()
            if (task.isNotEmpty()){
                tasks.add(task)
                adapter.notifyDataSetChanged()
                editTextInput.text.clear()
                Toast.makeText(this, "Task Added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(
                    this, "Please Enter a Task!", Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}

//class MainActivity : AppCompatActivity() {
//    private val tasks = mutableListOf<String>()
//    private lateinit var adapter: ArrayAdapter<String>
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val editTextInput = findViewById<EditText>(R.id.editTextInput)
//        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
//        val listViewTasks = findViewById<ListView>(R.id.listViewTasks)
//        val adapter = ArrayAdapter(
//            this, android.R.layout.simple_list_item_1, tasks
//        )
//        listViewTasks.adapter = adapter
//        buttonAdd.setOnClickListener {
//            val task = editTextInput.text.toString()
//            if (task.isNotEmpty()){
//                tasks.add(task)
//                adapter.notifyDataSetChanged()
//                editTextInput.text.clear()
//                Toast.makeText(
//                    this, "Task Added!", Toast.LENGTH_LONG
//                ).show()
//            } else {
//                Toast.makeText(this, "Please Enter a task.", Toast.LENGTH_LONG).show()
//            }
//        }
//
//        listViewTasks.setOnItemClickListener{_, _, position, _ ->
//            Toast.makeText(this, "Clicked: ${tasks[position]}", Toast.LENGTH_SHORT).show()
//        }
//    }
//}