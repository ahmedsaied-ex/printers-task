package com.example.printers.ui.holders.amjad

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.NewsData
import com.example.printers.databinding.NewsItemLayoutBinding

class NewsViewHolder(val binding: NewsItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {
        val text = binding.tvNewsText
    val img = binding.ivNews
    val numberOfViews = binding.tvNewsNumber
}