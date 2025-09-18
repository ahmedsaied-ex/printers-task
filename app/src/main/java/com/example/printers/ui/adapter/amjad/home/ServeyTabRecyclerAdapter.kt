package com.example.printers.ui.adapter.amjad.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.R
import com.example.printers.data.amjad.SurveysTabsData
import com.example.printers.databinding.ServeyTapsLayoutBinding
import com.example.printers.ui.holders.amjad.SurveysTabsViewHolder

class ServeyTabRecyclerAdapter(
    val list : List<SurveysTabsData>
): RecyclerView.Adapter<SurveysTabsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SurveysTabsViewHolder {
        val binding = ServeyTapsLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SurveysTabsViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SurveysTabsViewHolder,
        position: Int
    ) {
        val item = list[position]
        holder.number.text = item.number
        holder.text.text = item.text

    }


    override fun getItemCount(): Int = list.size
}