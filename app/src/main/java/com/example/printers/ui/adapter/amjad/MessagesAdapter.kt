package com.example.printers.ui.adapter.amjad

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.MessageData
import com.example.printers.databinding.MessageItemLayoutBinding
import com.example.printers.ui.holders.amjad.MessageViewHolder

class MessagesAdapter(
    private val messages: List<MessageData>
) : RecyclerView.Adapter<MessageViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val binding = MessageItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MessageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messages[position]
        holder.img.setImageResource(message.img)
        holder.messageContent.text = message.messageContent
        holder.tvDate.text = message.date
    }

    override fun getItemCount(): Int = messages.size
}
