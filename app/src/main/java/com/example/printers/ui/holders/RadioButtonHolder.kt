package com.example.printers.ui.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.databinding.RodioItemBinding

class RadioButtonHolder(view : RodioItemBinding) : RecyclerView.ViewHolder(view.root) {
    val radioButton = view.radioButton
    val textView = view.tvOption
}