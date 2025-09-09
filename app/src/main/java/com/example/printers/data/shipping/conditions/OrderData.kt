package com.example.printers.data.shipping.conditions

data class OrderData(
    val shippingCompany: String,
    val paymentMethod: String,
    val discount: String?,
    val weight: Double,
    val price: Double
)