package com.example.printers.data.shipping.discounts

import com.example.printers.data.shipping.discounts.IDiscounts

class ThirtyPercent(val name: String) : IDiscounts {
    override fun getPercentName(): String {
        return name
    }


}