package com.example.printers.data.shipping.conditions

import com.example.printers.data.shipping.discounts.DiscountsMethods
import com.example.printers.data.shipping.discounts.TenPercent
import com.example.printers.data.shipping.payment.PaymentMethods

class WeightMoreThan250() : IConditions {
    override fun isValid(orderData: OrderData): Boolean {
        return (orderData.weight >= 250 && orderData.paymentMethod == PaymentMethods.CREDIT_CARD.paymentName && orderData.discount != DiscountsMethods.TEN.percent.toString())
    }

    override fun getMessages(): String {
       return "this purchase can't be done"
    }


}