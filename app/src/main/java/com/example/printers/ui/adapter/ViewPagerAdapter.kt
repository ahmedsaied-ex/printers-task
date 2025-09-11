package com.example.printers.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.printers.ui.fragments.FragmentFour
import com.example.printers.ui.fragments.FragmentOne
import com.example.printers.ui.fragments.FragmentThree
import com.example.printers.ui.fragments.FragmentTwo

class ViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {
     val list = listOf(
         FragmentOne(), FragmentTwo(), FragmentThree(), FragmentFour()
    )
    override fun getItemCount(): Int = list.size


    override fun createFragment(position: Int): Fragment = list[position]
}