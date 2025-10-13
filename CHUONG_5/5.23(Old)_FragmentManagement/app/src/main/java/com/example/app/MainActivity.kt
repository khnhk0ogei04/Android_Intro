package com.example.app

import android.os.Bundle
import android.widget.Toast
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHome.setOnClickListener {
            if (!supportFragmentManager.isStateSaved) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                        .replace(R.id.fragmentContainer, HomeFragment())
                        .addToBackStack(null)
                }
            }
        }

        binding.btnProfile.setOnClickListener {
            if (!supportFragmentManager.isStateSaved) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, ProfileFragment())
                    addToBackStack(null)
                }
            }
        }

        binding.btnSettings.setOnClickListener {
            if (!supportFragmentManager.isStateSaved) {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace(R.id.fragmentContainer, SettingsFragment())
                    addToBackStack(null)
                }
            }
        }

        binding.btnHide.setOnClickListener {
            val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            if (currentFragment != null) {
                supportFragmentManager.beginTransaction()
                    .hide(currentFragment)
                    .commit()
                Toast.makeText(this, "This fragment is hiding", Toast.LENGTH_LONG).show()
            }
        }

        onBackPressedDispatcher.addCallback(this) {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                finish()
            }
        }
    }
}