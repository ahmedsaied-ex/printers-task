package com.example.printers.ui.adapter.amjad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.MostUsedOffer
import com.example.printers.databinding.MostUsedItemLayoutBinding
import com.example.printers.ui.holders.amjad.MostUsedOfferViewHolder

class MostUsedOffersAdapter(
    private val offersList: List<MostUsedOffer>
) : RecyclerView.Adapter<MostUsedOfferViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MostUsedOfferViewHolder {
        val binding = MostUsedItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MostUsedOfferViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MostUsedOfferViewHolder, position: Int) {
        val offer = offersList[position]
        holder.headText.text = offer.headText
        holder.thumbnails.setImageResource(offer.thumbnailImg)
        holder.marketImg.setImageResource(offer.marketImg)
        holder.marketName.text = offer.marketName
    }

    override fun getItemCount(): Int = offersList.size
}
