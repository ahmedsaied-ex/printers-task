package com.example.printers.data.shipping.companies

interface Shipping {

     fun getShippingName(): String
     fun getWeight(wight: Double): Double {
        return wight
    }

}