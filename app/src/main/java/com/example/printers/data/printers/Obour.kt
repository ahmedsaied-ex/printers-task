package com.example.printers.data.printers

class Obour(override val weight: Double) : Shipping  {
    override val name: String
        get() = "Obour"
}