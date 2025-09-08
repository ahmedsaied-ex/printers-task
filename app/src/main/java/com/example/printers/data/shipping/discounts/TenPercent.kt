package com.example.printers.data.shipping.discounts

import com.example.printers.data.shipping.discounts.IDiscounts

class TenPercent(val name: String) : IDiscounts {
    override fun getPercentName(): String {
        return name
    }

}