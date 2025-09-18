package com.example.printers.ui.adapter.amjad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.OffersData
import com.example.printers.databinding.OffersItemLayoutBinding
import com.example.printers.ui.holders.amjad.OffersViewHolder

class OffersAdapter(
    private val offersList: List<OffersData>
) : RecyclerView.Adapter<OffersViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val binding = OffersItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OffersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
       val item = offersList[position]
        holder.img.setImageResource(item.img)
        holder.text.text = item.text
    }

    override fun getItemCount(): Int = offersList.size
}
