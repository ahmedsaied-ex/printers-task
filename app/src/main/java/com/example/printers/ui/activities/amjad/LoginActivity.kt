package com.example.printers.ui.activities.amjad

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.printers.data.MyConstants
import com.example.printers.data.shared_prefrances.SharedPrefs
import com.example.printers.databinding.ActivityLoginBinding
import com.example.printers.ui.activities.amjad.RegesterActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPrefs: SharedPrefs
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViews()

        callBacks()

    }

    private fun callBacks() {
        binding.btLogin.setOnClickListener {
            if (binding.etPhone.text.toString().isEmpty()) {
                Toast.makeText(this, "enter phone number", Toast.LENGTH_SHORT).show()
            }else{
                val fullPhone = StringBuilder()
                fullPhone.append("+",binding.ccpNumber.selectedCountryCode.toString(), binding.etPhone.text.toString().trim())
                val mySet=sharedPrefs.read(MyConstants.MY_PHONE_NUMBERS, emptySet()).toMutableSet()
                sharedPrefs.write(MyConstants.IS_LOGIN, true)
                Log.d("REGESTER_TAG", sharedPrefs.read(MyConstants.IS_LOGIN, false).toString())
                if (mySet.contains(fullPhone.toString())){
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
                else{
                    startActivity(Intent(this, RegesterActivity::class.java))
                    finish()
                }


            }
        }

        binding.tvRegister.setOnClickListener {
            startActivity(Intent(this, RegesterActivity::class.java))
            finish()
        }
    }

    private fun initViews() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        sharedPrefs= SharedPrefs.getInstance(applicationContext)

    }

}