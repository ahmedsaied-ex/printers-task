package com.example.printers.data.shipping.conditions

import com.example.printers.data.shipping.companies.ShippingCompanies
import com.example.printers.data.shipping.discounts.DiscountsMethods
import com.example.printers.data.shipping.discounts.TenPercent
import com.example.printers.data.shipping.payment.PaymentMethods

class PayPalAndShorouk() : IConditions {
    override fun isValid(orderData: OrderData): Boolean {
        return  (
            orderData.paymentMethod == PaymentMethods.PAYPAL.paymentName &&
            orderData.shippingCompany == ShippingCompanies.SHROUK.shippingName &&
            orderData.discount == DiscountsMethods.THIRTY.percent.toString()
        )

}

    override fun getMessages(): String  ="can't use this discount for this purchase"
}