package com.example.printers.data.shipping.conditions

import android.content.Context
import androidx.appcompat.app.AlertDialog

interface IConditions {
    fun isValid(orderData: OrderData) : Boolean

    fun getMessages() : String
}