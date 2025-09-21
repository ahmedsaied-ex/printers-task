package com.example.printers.ui.activities.amjad

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.printers.R
import com.example.printers.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()
        //setupBottomNavigation()
    }

    private fun initView() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    private fun setupBottomNavigation() {
        // Find the NavController
        val navController = findNavController(R.id.fragmentContainerView2)

        // Connect BottomNavigationView with NavController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}