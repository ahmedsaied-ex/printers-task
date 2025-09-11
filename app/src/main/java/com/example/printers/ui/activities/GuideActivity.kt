package com.example.printers.ui.activities

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.WindowInsets

import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.printers.R
import com.example.printers.databinding.ActivityGuideBinding
import com.example.printers.ui.adapter.ViewPagerAdapter


class GuideActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuideBinding
    private lateinit var indicators: Array<ImageView?>
    private lateinit var adapter: ViewPagerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)


        initViews()

        initAdapter()

        initIndicator()

        callBacks()


    }

    private fun callBacks() {

        binding.vpOnBoarding.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)

                when (position) {
                    0 -> {
                        binding.btNext.visibility = View.VISIBLE
                        binding.btSkip.visibility = View.VISIBLE
                        binding.btLogin.visibility = View.GONE
                        binding.root.setBackgroundColor(
                            ContextCompat.getColor(
                                this@GuideActivity, R.color.main_back_ground_Color
                            )
                        )
                    }

                    adapter.itemCount - 1 -> {
                        binding.btNext.visibility = View.GONE
                        binding.btSkip.visibility = View.GONE
                        binding.btLogin.visibility = View.VISIBLE
                        binding.root.setBackgroundColor(
                            ContextCompat.getColor(
                                this@GuideActivity, R.color.background_light
                            )
                        )
                    }

                    else -> {
                        binding.btNext.visibility = View.VISIBLE
                        binding.btSkip.visibility = View.VISIBLE
                        binding.btLogin.visibility = View.GONE
                        binding.root.setBackgroundColor(
                            ContextCompat.getColor(
                                this@GuideActivity, R.color.background_light
                            )
                        )
                    }
                }
            }
        })

        binding.btNext.setOnClickListener {
            val currentItem = binding.vpOnBoarding.currentItem
            if (currentItem < adapter.itemCount - 1) {
                binding.vpOnBoarding.currentItem = currentItem + 1
            }
        }

        binding.btSkip.setOnClickListener {
            binding.vpOnBoarding.currentItem = adapter.list.size - 1
        }
    }

    private fun initIndicator() {
        setupIndicators(adapter.list.size)
        setCurrentIndicator(0)
    }

    private fun initAdapter() {
        adapter = ViewPagerAdapter(
            fragmentManager = supportFragmentManager, lifecycle = lifecycle,
        )

        binding.vpOnBoarding.adapter = adapter
        binding.vpOnBoarding.layoutDirection = View.LAYOUT_DIRECTION_RTL
    }

    private fun initViews() {
        binding = ActivityGuideBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    private fun setupIndicators(count: Int) {
        indicators = arrayOfNulls(count)

        binding.llTabIndicator.removeAllViews()

        val layoutParams = LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        )

        for (i in 0 until count) {
            indicators[i] = ImageView(this).apply {

                layoutParams.width = 40
                layoutParams.height = 40
                setImageDrawable(
                    ContextCompat.getDrawable(
                        this@GuideActivity, R.drawable.dot_unselected
                    )
                )
                this.layoutParams = layoutParams
                scaleType = ImageView.ScaleType.CENTER
            }
            binding.llTabIndicator.addView(indicators[i])
        }
        binding.llTabIndicator.requestLayout()
    }

    private fun setCurrentIndicator(index: Int) {
        if (index < 0 || index >= indicators.size) {//to ensure that the number will be sent is in the list
            Log.e(
                "setCurrentIndicator", "Invalid index: $index, indicators size: ${indicators.size}"
            )
            return
        }

        for (i in indicators.indices) {
            val indicator = indicators[i]
            if (indicator != null) {
                if (i == index) {
                    indicator.setImageDrawable(
                        ContextCompat.getDrawable(this, R.drawable.dot_selected)
                    )
                } else {
                    if (index == 0) {
                        indicator.setImageDrawable(
                            ContextCompat.getDrawable(this, R.drawable.dot_un_selected_white)
                        )
                    } else {
                        indicator.setImageDrawable(
                            ContextCompat.getDrawable(this, R.drawable.dot_unselected)
                        )
                    }
                }
            } else {
                Log.e("setCurrentIndicator", "Indicator at index $i is null")
            }
        }
    }
}