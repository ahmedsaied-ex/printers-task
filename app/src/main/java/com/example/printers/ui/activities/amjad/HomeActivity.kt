package com.example.printers.ui.activities.amjad

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.printers.R
import com.example.printers.databinding.ActivityHomeBinding
import com.example.printers.ui.fragments.main.HomeFragment

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragmentContainerView, HomeFragment())
//            .commit()

    }

    private fun initView() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}