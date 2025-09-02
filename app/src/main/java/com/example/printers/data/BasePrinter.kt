package com.example.printers.data

import android.content.Context
import android.widget.Toast

interface BasePrinter {
    val model: PrinterModel
    abstract fun makeToast(context: Context , name: String, ip: String)

}