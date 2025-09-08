package com.example.printers.data.shipping.companies


class Obour(val name: String) : Shipping {


    override fun getShippingName(): String {
        return name
    }

    override fun getWeight(wight: Double) : Double {
        return wight
    }
}