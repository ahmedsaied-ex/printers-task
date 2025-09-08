package com.example.printers.data.shipping.payment

import com.example.printers.data.shipping.payment.IPayment

class Cash(): IPayment {
    override fun getName(): String = PaymentMethods.CASH.paymentName




}