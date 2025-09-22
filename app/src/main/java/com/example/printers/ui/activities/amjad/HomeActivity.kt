package com.example.printers.ui.activities.amjad


import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.fragment.NavHostFragment
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import androidx.navigation.ui.setupWithNavController
import com.example.printers.R
import com.example.printers.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityHomeBinding
    private var currentIndex = 0
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        initView()
        setupBottomNavigation()
        initImageSwitcher()
        callBacks()
        initImageSwitcher()

    }

    private fun initImageSwitcher() {
        val emojiList = listOf(
            R.drawable.emoji,       // replace with your real drawables
            R.drawable.emoji2, R.drawable.emoji_happy, R.drawable.emoji_angry
        )

        val runnable = object : Runnable {
            override fun run() {

                val slideOut = AnimationUtils.loadAnimation(this@HomeActivity, R.anim.slide_out_top)
                val slideIn =
                    AnimationUtils.loadAnimation(this@HomeActivity, R.anim.slide_in_bottom)

                binding.ivEmoji.startAnimation(slideOut)

                slideOut.setAnimationListener(object :
                    android.view.animation.Animation.AnimationListener {
                    override fun onAnimationStart(animation: android.view.animation.Animation?) {}

                    override fun onAnimationEnd(animation: android.view.animation.Animation?) {

                        currentIndex = (currentIndex + 1) % emojiList.size
                        binding.ivEmoji.setImageResource(emojiList[currentIndex])
                        binding.ivEmoji.startAnimation(slideIn)
                    }

                    override fun onAnimationRepeat(animation: android.view.animation.Animation?) {}
                })

                handler.postDelayed(this, 1500)
            }
        }
        handler.post(runnable)


    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacksAndMessages(null)
    }


    private fun callBacks() {
        binding.ivWhatYouFeelClose.setOnClickListener {
            binding.clWhatYouFeel.visibility = View.GONE
        }

    }

    private fun initView() {
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }


    private fun setupBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNavigationView.setupWithNavController(navController)
    }
}