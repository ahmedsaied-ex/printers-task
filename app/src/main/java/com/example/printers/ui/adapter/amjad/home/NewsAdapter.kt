package com.example.printers.ui.adapter.amjad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.NewsData
import com.example.printers.databinding.NewsItemLayoutBinding
import com.example.printers.ui.holders.amjad.NewsViewHolder

class NewsAdapter(
    private val newsList: List<NewsData>
) : RecyclerView.Adapter<NewsViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = NewsItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]
        holder.img.setImageResource(item.img)
        holder.text.text = item.text
        holder.numberOfViews.text = item.numberOfViews
    }/*
    binding.ivNews.setImageResource(item.img)
        binding.tvNewsText.text = item.text
        binding.tvNewsNumber.text = item.numberOfViews
    */

    override fun getItemCount(): Int = newsList.size
}
