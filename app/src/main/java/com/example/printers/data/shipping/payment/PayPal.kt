package com.example.printers.data.shipping.payment

import com.example.printers.data.shipping.payment.IPayment

class PayPal() : IPayment {
    override fun getName(): String = PaymentMethods.PAYPAL.paymentName



}