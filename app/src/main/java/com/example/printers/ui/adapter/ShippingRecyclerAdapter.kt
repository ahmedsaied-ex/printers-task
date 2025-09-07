package com.example.printers.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.ui.holders.RadioButtonHolder

class ShippingRecyclerAdapter(
    val list :List<>,
): RecyclerView.Adapter<RadioButtonHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RadioButtonHolder {

    }

    override fun onBindViewHolder(holder: RadioButtonHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}