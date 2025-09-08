package com.example.printers.data.printers

import android.content.Context
import android.widget.Toast
import com.example.printers.R
import com.example.printers.data.printers.Toastable

class ErrorPrinter(override val model: PrinterModel) : BasePrinter, Toastable, Colorable {
    override fun makeToast(
        context: Context, name: String, ip: String
    ) {
        Toast.makeText(context, "$name Error Printer $ip", Toast.LENGTH_SHORT).show()
    }

    override val color = R.color.red

}