package com.example.printers.data

import android.content.Context

interface Toastable {
    abstract fun makeToast(context: Context , name: String, ip: String)
}

