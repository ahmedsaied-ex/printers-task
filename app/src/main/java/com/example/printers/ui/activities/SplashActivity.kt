package com.example.printers.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.printers.R
import com.example.printers.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)

        setContentView(binding.root)


    }

    override fun onStart() {
        super.onStart()

        // Start fade+scale animation when splash appears
        binding.ivAmjad.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_in_animation))
        binding.textView8.startAnimation(AnimationUtils.loadAnimation(this, R.anim.move_up_animation))


        // Delay, then fade out + go to next activity
        Handler(Looper.getMainLooper()).postDelayed({
            binding.ivAmjad.startAnimation(AnimationUtils.loadAnimation(this, R.anim.fade_out))
            startActivity(Intent(this, GuideActivity::class.java))
            finish()
        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        Log.d("SplashActivity_LOG", "onResume")
    }
}