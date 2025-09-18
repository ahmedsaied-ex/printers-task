package com.example.printers.ui.adapter.amjad.home

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.BannerData
import com.example.printers.databinding.ImgBannerLayoutBinding
import com.example.printers.ui.holders.amjad.BannerImgHolder
import java.util.zip.Inflater

class BannerRecyclerAdapter( val list: List<BannerData>): RecyclerView.Adapter<BannerImgHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BannerImgHolder {
        Log.d("RECYCLER_TAG", "onCreateViewHolder: ")
        val binding = ImgBannerLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BannerImgHolder(binding)
    }


    override fun onBindViewHolder(
        holder: BannerImgHolder,
        position: Int
    ) {
       val item =list[position]
        holder.img.setImageResource(item.img)
        Log.d("RECYCLER_TAG", "onBindViewHolder: ${item.img}")
    }

    override fun getItemCount(): Int  = list.size
}