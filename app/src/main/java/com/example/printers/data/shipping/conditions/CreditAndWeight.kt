package com.example.printers.data.shipping.conditions

import com.example.printers.data.shipping.companies.ShippingCompanies
import com.example.printers.data.shipping.discounts.DiscountsMethods
import com.example.printers.data.shipping.discounts.IDiscounts
import com.example.printers.data.shipping.discounts.TenPercent
import com.example.printers.data.shipping.payment.PaymentMethods


class CreditAndWeight() : IConditions {
    override fun isValid(orderData: OrderData): Boolean {
        return (
                orderData.weight >= 100 &&
                        orderData.paymentMethod == PaymentMethods.CREDIT_CARD.paymentName &&
                        orderData.shippingCompany == ShippingCompanies.OUBOUR.shippingName)
    }

    override fun getMessages(): String  = "can't use Oubour with weight more than 100"
}


