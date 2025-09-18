package com.example.printers.ui.adapter.amjad.home

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.printers.ui.fragments.main.hrRequestsFragments.HrFragmentOne
import com.example.printers.ui.fragments.main.hrRequestsFragments.HrFragmentTwo

class HrViewPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    private val list = listOf(HrFragmentOne(),HrFragmentTwo())
    override fun createFragment(position: Int): Fragment = list[position]

    override fun getItemCount(): Int =list.size
}