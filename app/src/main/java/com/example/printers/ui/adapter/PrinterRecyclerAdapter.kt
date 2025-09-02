package com.example.printers.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.R
import com.example.printers.data.DataModel
import com.example.printers.data.ErrorPrinter
import com.example.printers.data.MainPrinter
import com.example.printers.data.OfflinePrinter
import com.example.printers.data.PrinterModel
import com.example.printers.databinding.PrinterCardBinding
import com.example.printers.ui.holders.PrinterCardHolder

class PrinterRecyclerAdapter(
    val list :List<DataModel>,
) : RecyclerView.Adapter<PrinterCardHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PrinterCardHolder {
        val binding = PrinterCardBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PrinterCardHolder(binding)
    }

    override fun onBindViewHolder(holder: PrinterCardHolder, position: Int) {
        val item = list[position]
        val context = holder.itemView.context
        holder.name.text = item.name
        holder.type.text = item.type
        holder.ip.text = item.ip.toString()

        val printer = when {
            item.isMain -> {
                holder.binding.tvPrinterName.setTextColor(ContextCompat.getColor(context,R.color.green))
                MainPrinter(PrinterModel(item.name, item.type, item.ip))
            }
            item.isError -> {
                holder.binding.tvPrinterName.setTextColor(ContextCompat.getColor(context,R.color.red))
                ErrorPrinter(PrinterModel(item.name, item.type, item.ip))
            }
            item.isOffline -> {
                holder.binding.tvPrinterName.setTextColor(ContextCompat.getColor(context,R.color.blue))
                OfflinePrinter(PrinterModel(item.name, item.type, item.ip))
            }
            else -> null
        }

        holder.itemView.setOnClickListener {
            printer?.makeToast(context, item.name, item.ip.toString())
        }
    }

    override fun getItemCount() = list.size
}