package com.example.printers.ui.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.databinding.RadioOptionCardBinding

class RadioOptionHolder(val binding: RadioOptionCardBinding) :  RecyclerView.ViewHolder(binding.root){
    val textView = binding.tvOptionName
    val radioButton = binding.radioButton
}