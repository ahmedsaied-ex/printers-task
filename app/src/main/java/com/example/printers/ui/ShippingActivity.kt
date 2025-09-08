package com.example.printers.ui

import android.os.Bundle
import android.util.Log
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
            Log.d("Condition TAG", "callBacks: ${discountsAdapter.getSelectedItem()}")
            Log.d("Condition TAG", "callBacks: ${paymentAdapter.getSelectedItem()}")
            Log.d("Condition TAG", "callBacks: ${shippingAdapter.getSelectedItem()}")
            if (binding.etWeight.editText?.text?.toString()?.trim().isNullOrBlank()) {
                binding.etWeight.error = "Please enter weight"
            } else if (binding.etPrice.editText?.text?.toString()?.trim().isNullOrBlank()) {
                binding.etPrice.error = "Please enter price"

            } else {
                if (shippingAdapter.getSelectedItem() == ShippingCompanies.ARAMAX.shippingName &&
                    paymentAdapter.getSelectedItem() == PaymentMethods.CREDIT_CARD.paymentName &&
                    discountsAdapter.getSelectedItem() != null) {
                    message = "cant add discounts"
                }
                else if (paymentAdapter.getSelectedItem() == PaymentMethods.CREDIT_CARD.paymentName &&
                    shippingAdapter.getSelectedItem() == ShippingCompanies.OUBOUR.shippingName &&
                    discountsAdapter.getSelectedItem() != "${DiscountsMethods.TEN.percent}%") {
                    message = "cant add discounts more than 10 % "

                }
                else if (
                    binding.etWeight.editText?.text.toString().toDouble() >= 100 &&
                    paymentAdapter.getSelectedItem() == PaymentMethods.CREDIT_CARD.paymentName &&
                    shippingAdapter.getSelectedItem() == ShippingCompanies.OUBOUR.shippingName) {
                    message = "sorry but you cant use OUBOUR with weight more than 100"

                }
                else if (
                    binding.etWeight.editText?.text.toString().toDouble() > 250 &&
                    paymentAdapter.getSelectedItem() == PaymentMethods.CREDIT_CARD.paymentName &&
                    discountsAdapter.getSelectedItem() != "${DiscountsMethods.TEN.percent}%"
                ) {
                    message =
                        "Sorry but the weight is more than 250 and you cant use credit card and the discount is not <= 10 %"
                }
                else {

                    message =
                        "Company name  : ${shippingAdapter.getSelectedItem()}\n" +
                                "price before discount : ${binding.etPrice.editText?.text}\n" +
                                "price after discount : ${
                                    TenPercent(DiscountsMethods.TEN.percent.toString()).pay(
                                        binding.etPrice.editText?.text.toString().toDouble(),
                                        discountsAdapter.getSelectedItem()?.toInt()
                                    )
                                }\n"
                }

                AlertDialog.Builder(this)
                    .setTitle("Alert Title")
                    .setMessage(message)
                    .setPositiveButton("OK", null)
                    .show()
            }

        }
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