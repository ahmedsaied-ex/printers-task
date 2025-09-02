package com.example.printers.data

import android.content.Context
import android.widget.Toast

class MainPrinter(
     override val model: PrinterModel
) : BasePrinter{
     override fun makeToast(
          context: Context,
          name: String,
          ip: String) {
          Toast.makeText(context, "$name Main Printer $ip", Toast.LENGTH_SHORT).show()
     }

}