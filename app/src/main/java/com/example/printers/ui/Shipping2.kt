package com.example.printers.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.printers.databinding.ActivityShippingBinding

class Shipping2 : AppCompatActivity() {


    lateinit var binding: ActivityShippingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()

    }

    private fun initView() {
        binding = ActivityShippingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}