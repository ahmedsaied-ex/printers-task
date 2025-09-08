package com.example.printers.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.databinding.RadioOptionCardBinding
import com.example.printers.ui.holders.RadioOptionHolder

class RadioButtonRecyclerViewAdapter(
    val myList: List<Any>
) : RecyclerView.Adapter<RadioOptionHolder>() {
    private var selectedPosition = -1

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): RadioOptionHolder {
        val binding = RadioOptionCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return RadioOptionHolder(binding)
    }

    override fun onBindViewHolder(
        holder: RadioOptionHolder, position: Int
    ) {
        holder.textView.text = myList[position].toString()
        holder.radioButton.isChecked = position == selectedPosition


        holder.itemView.setOnClickListener {
            val currentPos = holder.adapterPosition
            if (currentPos != RecyclerView.NO_POSITION) {
                selectedPosition = currentPos
                notifyDataSetChanged()
            }
        }

        holder.radioButton.setOnClickListener {
            val currentPos = holder.adapterPosition
            if (currentPos != RecyclerView.NO_POSITION) {
                selectedPosition = currentPos
                notifyDataSetChanged()
            }
        }

    }

    fun getSelectedItem(): String? {
        return if (selectedPosition != -1) myList[selectedPosition].toString()
        else null
    }

    override fun getItemCount() = myList.size
}