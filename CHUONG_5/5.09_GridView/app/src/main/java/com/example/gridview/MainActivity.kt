package com.example.gridview

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.GridView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
//    private val items = mutableListOf<String>()
//    private lateinit var adapter: ArrayAdapter<String>
    private val products = mutableListOf<Product>()
    private lateinit var adapter: ProductAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editTextInput = findViewById<EditText>(R.id.editTextInput)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val gridViewItems = findViewById<GridView>(R.id.gridViewItems)

        products.add(Product("Product 1", R.drawable.ic_launcher_background))
        products.add(Product("Product 2", R.drawable.ic_launcher_background))
//        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
        adapter = ProductAdapter(this, products)
        gridViewItems.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextInput.text.toString()
            if (name.isNotEmpty()){
//                items.add(item)
                products.add(Product(name, R.drawable.ic_launcher_background))
                adapter.notifyDataSetChanged()
                editTextInput.text.clear()
                Toast.makeText(this, "Item added!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter an item.", Toast.LENGTH_SHORT).show()
            }
        }

//        gridViewItems.setOnItemClickListener{ _, _, position, _ ->
//            Toast.makeText(this, "Clicked: ${products[position]}", Toast.LENGTH_SHORT).show()
//        }
    }
}