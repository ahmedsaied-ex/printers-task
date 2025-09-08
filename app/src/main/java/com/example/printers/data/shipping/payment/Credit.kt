package com.example.printers.data.shipping.payment

import com.example.printers.data.shipping.payment.IPayment

class Credit() : IPayment {
    override fun getName(): String = PaymentMethods.CREDIT_CARD.paymentName

}