package com.example.printers.ui.holders

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.databinding.PrinterCardBinding

class PrinterCardHolder(val binding: PrinterCardBinding) : RecyclerView.ViewHolder(binding.root) {
    val name = binding.tvPrinterName
    val type = binding.tvPrinterType
    val ip = binding.tvPrinterIp
}