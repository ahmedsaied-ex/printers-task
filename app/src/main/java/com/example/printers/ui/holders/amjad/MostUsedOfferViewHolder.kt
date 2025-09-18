package com.example.printers.ui.holders.amjad

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.MostUsedOffer
import com.example.printers.databinding.MostUsedItemLayoutBinding


class MostUsedOfferViewHolder(val binding: MostUsedItemLayoutBinding) :
RecyclerView.ViewHolder(binding.root) {

    val headText = binding.tvHeadText
    val thumbnails = binding.ivThumbNail
    val marketName = binding.marketName
    val marketImg = binding.ivMarketImg
}