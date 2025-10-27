package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.UserAdapter
import com.example.myapplication.ui.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val adapter = UserAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter
        binding.recycler.addItemDecoration(
            DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        )
        val vm = ViewModelProvider(this)[UserViewModel::class.java]

        binding.progress.visibility = View.VISIBLE
        vm.loadUsers()

        vm.users.observe(this) { list ->
            binding.progress.visibility = View.GONE
            binding.errorGroup.visibility = View.GONE
            adapter.submit(list)
        }
        vm.error.observe(this) { msg ->
            if (msg != null) {
                binding.progress.visibility = View.GONE
                binding.errorGroup.visibility = View.VISIBLE
                binding.textError.text = msg
            }
        }

        binding.btnRetry.setOnClickListener {
            binding.progress.visibility = View.VISIBLE
            binding.errorGroup.visibility = View.GONE
            vm.loadUsers()
        }
    }
}