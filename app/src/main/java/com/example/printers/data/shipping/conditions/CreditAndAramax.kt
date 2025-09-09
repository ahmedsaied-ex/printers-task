package com.example.printers.data.shipping.conditions


import com.example.printers.data.shipping.companies.ShippingCompanies
import com.example.printers.data.shipping.payment.PaymentMethods

class CreditAndAramax(

) : IConditions {
    override fun isValid(orderData: OrderData): Boolean {
        return (orderData.shippingCompany == ShippingCompanies.ARAMAX.shippingName &&
                orderData.paymentMethod == PaymentMethods.CREDIT_CARD.paymentName &&
                orderData.discount != null)


    }

    override fun getMessages(): String {
        return "can't do discount to this purchase"
    }


}