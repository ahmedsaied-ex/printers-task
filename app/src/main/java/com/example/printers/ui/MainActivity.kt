package com.example.printers.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printers.data.printers.DataManager
import com.example.printers.databinding.ActivityMainBinding
import com.example.printers.ui.adapter.PrinterRecyclerAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()
        initRecycler()
    }



    private fun initRecycler() {
        binding.rvPrinters.layoutManager = LinearLayoutManager(this)
        binding.rvPrinters.adapter = PrinterRecyclerAdapter(
            list = DataManager().printers,
        )
    }



    private fun initView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}