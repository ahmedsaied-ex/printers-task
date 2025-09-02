package com.example.printers.data

data class PrinterModel(
    val name: String,
    val type: String,
    val ip: Int,
    )
/*
* override fun onBindViewHolder(holder: PrinterCardHolder, position: Int) {
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

*
*
* */