package com.example.printers.data.printers

class Shorouk(override val weight: Double) : Shipping {
    override val name: String
        get() = "Shorouk"
}