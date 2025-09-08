package com.example.printers.data.shipping.companies



class Aramax(val name: String) : Shipping {
    override fun getShippingName(): String {
        return name
    }

    //    override fun getName(): String {
//        return name
//    }
    override fun getWeight(wight: Double) : Double {
        return wight
    }
}