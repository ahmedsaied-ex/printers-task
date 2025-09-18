package com.example.printers.ui.activities.amjad

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.printers.R
import com.example.printers.data.MyConstants
import com.example.printers.data.shared_prefrances.SharedPrefs
import com.example.printers.databinding.ActivityRegesterBinding
import kotlin.math.log

class RegesterActivity : AppCompatActivity() {
    lateinit var sharedPrefs: SharedPrefs
    lateinit var binding: ActivityRegesterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViews()
        callBacks()

    }

    private fun callBacks() {
        binding.btRegister.setOnClickListener {
            if (binding.etPhone.text.toString().isEmpty()){
               makeToast()
            }else{
                val fullPhone = StringBuilder()
                fullPhone.append("+",binding.ccpNumber.selectedCountryCode.toString(), binding.etPhone.text.toString().trim())

                val mySet=sharedPrefs.read(MyConstants.MY_PHONE_NUMBERS, emptySet()).toMutableSet()
                mySet.add(fullPhone.toString())
                sharedPrefs.write(MyConstants.MY_PHONE_NUMBERS, mySet)
                sharedPrefs.write(MyConstants.IS_LOGIN, true)
                Log.d("REGESTER_TAG", sharedPrefs.read(MyConstants.IS_LOGIN, false).toString())
                Log.d("REGESTER_TAG", sharedPrefs.read(MyConstants.MY_PHONE_NUMBERS, emptySet()).toString())
                startActivity(Intent(this, HomeActivity::class.java))
                finish()

//            startActivity(Intent(this, HomeActivity::class.java))
//            finish()
            }
        }

    }

    private fun initViews() {
        WindowCompat.setDecorFitsSystemWindows(window, true)
        binding= ActivityRegesterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPrefs= SharedPrefs.getInstance(applicationContext)
    }
}

private fun RegesterActivity.makeToast() {
    Toast.makeText(this, "enter phone number", Toast.LENGTH_SHORT).show()
}
