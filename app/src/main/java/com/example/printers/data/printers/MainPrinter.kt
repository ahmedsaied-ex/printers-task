package com.example.printers.data.printers

import android.content.Context
import android.widget.Toast
import com.example.printers.R

class MainPrinter(
    override val model: PrinterModel
) : BasePrinter, Toastable, Colorable {

    override fun makeToast(
        context: Context, name: String, ip: String
    ) {
        Toast.makeText(context, "$name Main Printer $ip", Toast.LENGTH_SHORT).show()
    }

    override val color = R.color.green

}