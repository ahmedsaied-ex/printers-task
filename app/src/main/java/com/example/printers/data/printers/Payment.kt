package com.example.printers.data.printers

interface Payment {
    val name: String
    fun pay(discount: Int? , price: Int): String {
        val total = price - (price *(discount?:0) / 100)
        return "$name $total"
    }
}