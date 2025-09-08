package com.example.printers.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.printers.databinding.ActivityShipping2Binding


class Shipping2 : AppCompatActivity() {


    lateinit var binding: ActivityShipping2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()






    }

    private fun initView() {
        binding = ActivityShipping2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}