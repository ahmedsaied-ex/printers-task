package com.example.printers.data

import android.content.Context
import android.widget.Toast
import com.example.printers.R

class OfflinePrinter(override val model: PrinterModel) : BasePrinter {
    override fun makeToast(
        context: Context,
        name: String,
        ip: String
    ) {

        Toast.makeText(context, "$name Offline Printer $ip", Toast.LENGTH_SHORT).show()

    }

    override val color = R.color.blue

}