package com.example.printers.ui.holders.amjad

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.MessageData
import com.example.printers.databinding.MessageItemLayoutBinding

 class MessageViewHolder(val binding: MessageItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root) {


        val  img = binding.ivAmjad
     val messageContent = binding.tvMessageContent
     val tvDate = binding.tvDate

}