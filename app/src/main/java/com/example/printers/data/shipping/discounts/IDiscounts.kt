package com.example.printers.data.shipping.discounts

interface IDiscounts  {
    fun getPercentName(): String
    fun pay( price: Double,percent: Int?): Double{
        val total = price - (price *(percent?:0) / 100)
        return total
    }
}