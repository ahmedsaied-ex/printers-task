package com.example.printers.ui

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.printers.data.shipping.companies.Aramax
import com.example.printers.data.shipping.companies.Obour
import com.example.printers.data.shipping.discounts.DiscountsMethods
import com.example.printers.data.shipping.payment.PaymentMethods
import com.example.printers.data.shipping.companies.ShippingCompanies
import com.example.printers.data.shipping.companies.Shorouk
import com.example.printers.data.shipping.conditions.CreditAndAramax
import com.example.printers.data.shipping.conditions.CreditAndOubour
import com.example.printers.data.shipping.conditions.CreditAndWeight
import com.example.printers.data.shipping.conditions.IConditions
import com.example.printers.data.shipping.conditions.OrderData
import com.example.printers.data.shipping.conditions.PayPalAndShorouk
import com.example.printers.data.shipping.conditions.WeightMoreThan250
import com.example.printers.data.shipping.discounts.TenPercent
import com.example.printers.data.shipping.discounts.ThirtyPercent
import com.example.printers.data.shipping.discounts.TwentyPercent
import com.example.printers.data.shipping.payment.Cash
import com.example.printers.data.shipping.payment.Credit
import com.example.printers.data.shipping.payment.PayPal
import com.example.printers.databinding.ActivityShipping2Binding
import com.example.printers.ui.adapter.RadioButtonRecyclerViewAdapter


class ShippingActivity : AppCompatActivity() {


    lateinit var binding: ActivityShipping2Binding
    lateinit var discountList: List<String>
    lateinit var paymentList: List<String>
    lateinit var shippingList: List<String>

    lateinit var shippingAdapter: RadioButtonRecyclerViewAdapter
    lateinit var paymentAdapter: RadioButtonRecyclerViewAdapter
    lateinit var discountsAdapter: RadioButtonRecyclerViewAdapter
    lateinit var message: String

    private val conditions = listOf<IConditions>(
        CreditAndAramax(),
        CreditAndOubour(),
        CreditAndWeight(),
        WeightMoreThan250(),
        PayPalAndShorouk()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()
        addData()
        initRecyclerViews()
        callBacks()

    }

    private fun addData() {
        discountList = listOf(
            TenPercent(DiscountsMethods.TEN.percent.toString()).getPercentName(),
            TwentyPercent(DiscountsMethods.TWENTY.percent.toString()).getPercentName(),
            ThirtyPercent(DiscountsMethods.THIRTY.percent.toString()).getPercentName()
        )
        paymentList = listOf(Cash().getName(), PayPal().getName(), Credit().getName())
        shippingList = listOf(
            Aramax(ShippingCompanies.ARAMAX.shippingName).getShippingName(),
            Obour(ShippingCompanies.OUBOUR.shippingName).getShippingName(),
            Shorouk(ShippingCompanies.SHROUK.shippingName).getShippingName()
        )
    }

    private fun callBacks() {
        binding.btCalculate.setOnClickListener {
            binding.etWeight.clearFocus()
            binding.etPrice.clearFocus()
            binding.etWeight.helperText = null
            binding.etPrice.helperText = null
            if (binding.etWeight.value().isBlank()) {
                binding.etWeight.helperText = "Please enter weight"
            } else if (binding.etPrice.value().isBlank()) {
                binding.etPrice.helperText = "Please enter price"
            } else {
                val orderData = OrderData(
                    shippingCompany = shippingAdapter.getSelectedItem() ?: "",
                    paymentMethod = paymentAdapter.getSelectedItem() ?: "",
                    discount = discountsAdapter.getSelectedItem(),
                    weight = binding.etWeight.editText?.text.toString().toDouble(),
                    price = binding.etPrice.editText?.text.toString().toDouble()
                )

                message = check(orderData)
                AlertDialog.Builder(this).setTitle("Alert Title").setMessage(message)
                    .setPositiveButton("OK", null).show()
            }

        }
    }

    private fun check(orderData: OrderData): String {
        // Check each condition in order

        for (condition in conditions) {
            Log.d("TAG Shipping activity", "check: ${condition.isValid(orderData)}")
            if (condition.isValid(orderData)) {
                return condition.getMessages()   // If the result contains an error message (not a calculation), return it
            }
        }

        // If no condition returned an error, calculate the final result
        return "shipping company ${orderData.shippingCompany}\n" + "price before discount : ${orderData.price}\n" + "price after discount : ${
            TenPercent(
                ""
            ).pay(orderData.price, orderData.discount?.toInt())
        } "
    }

    fun com.google.android.material.textfield.TextInputLayout.value(): String {
        return this.editText?.text.toString().trim()
    }

    private fun initRecyclerViews() {


        binding.rvDiscount.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPaymentMethods.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvShippingCompanies.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)




        shippingAdapter = RadioButtonRecyclerViewAdapter(shippingList)
        paymentAdapter = RadioButtonRecyclerViewAdapter(paymentList)
        discountsAdapter = RadioButtonRecyclerViewAdapter(discountList)

        binding.rvDiscount.adapter = discountsAdapter
        binding.rvPaymentMethods.adapter = paymentAdapter
        binding.rvShippingCompanies.adapter = shippingAdapter

    }

    private fun initView() {
        binding = ActivityShipping2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}