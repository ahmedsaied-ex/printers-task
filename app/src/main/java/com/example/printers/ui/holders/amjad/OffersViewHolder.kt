package com.example.printers.ui.holders.amjad

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.OffersData
import com.example.printers.databinding.OffersItemLayoutBinding

class OffersViewHolder(val binding: OffersItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {

        val img = binding.ivOfferImg
    val text = binding.tvOfferName

}