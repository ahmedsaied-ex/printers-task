package com.example.printers.data.printers

import android.content.Context

interface Toastable {
    abstract fun makeToast(context: Context , name: String, ip: String)
}

