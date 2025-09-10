package com.example.printers.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.printers.R

class FragmentTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_two, container, false)

        val viewPager = activity?.findViewById<ViewPager2>(R.id.vp_on_boarding)
        view.findViewById<Button>(R.id.button_next).setOnClickListener {
            viewPager?.currentItem = 2
        }
        return view
    }

}