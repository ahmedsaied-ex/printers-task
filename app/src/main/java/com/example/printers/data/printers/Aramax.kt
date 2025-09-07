package com.example.printers.data.printers

class Aramax(override val weight: Double) : Shipping {
    override val name: String
        get() = "Aramax"
}