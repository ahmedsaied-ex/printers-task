package com.example.printers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.printers.databinding.FragmentViewPagerBinding
import com.example.printers.ui.adapter.ViewPagerAdapter


class ViewPagerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
    val view_pager = FragmentViewPagerBinding.inflate(inflater, container, false)
        val fragmentList =listOf< Fragment>(
            FragmentOne(),
            FragmentTwo(),
            FragmentThree(),
            FragmentFour()
        )
        val adapter = ViewPagerAdapter(
            fragmentManager = requireActivity().supportFragmentManager,
            lifecycle = lifecycle,
            list = fragmentList
        )
        view_pager.vpOnBoarding.adapter=adapter

        return view_pager.root
    }
}