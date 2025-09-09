package com.example.printers.data.shipping.conditions

import com.example.printers.data.shipping.companies.ShippingCompanies
import com.example.printers.data.shipping.discounts.DiscountsMethods
import com.example.printers.data.shipping.discounts.TenPercent
import com.example.printers.data.shipping.payment.PaymentMethods

class CreditAndOubour(

) : IConditions {
    override fun isValid(orderData: OrderData): Boolean {
        return orderData.paymentMethod == PaymentMethods.CREDIT_CARD.paymentName &&
                orderData.shippingCompany == ShippingCompanies.OUBOUR.shippingName &&
                orderData.discount != "${DiscountsMethods.TEN.percent}"
    }

    override fun getMessages(): String = "can't do discount to this purchase"

}