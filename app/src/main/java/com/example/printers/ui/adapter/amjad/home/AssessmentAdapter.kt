package com.example.printers.ui.adapter.amjad.home

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.printers.data.amjad.AssessmentCardData
import com.example.printers.databinding.AssesmentCardLayoutBinding
import com.example.printers.ui.holders.amjad.AssessmentViewHolder

class AssessmentAdapter(
    private val items: List<AssessmentCardData>
) : RecyclerView.Adapter<AssessmentViewHolder>() {


    private val gradientPairs = listOf(
        intArrayOf(Color.parseColor("#D7CEFD"), Color.parseColor("#8A80DB")), // بنفسجي
        intArrayOf(Color.parseColor("#F2C9A5"), Color.parseColor("#FD9438")), // أورانج
        intArrayOf(Color.parseColor("#BCDD8A"), Color.parseColor("#6CBC6F"))  // أخضر
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AssessmentViewHolder {
        val binding = AssesmentCardLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return AssessmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AssessmentViewHolder, position: Int) {
        val item = items[position]
        holder.img.setImageResource(item.img)
        holder.headText.text = item.headText


        val colors = gradientPairs[position % gradientPairs.size]
        val gradientDrawable = GradientDrawable(
            GradientDrawable.Orientation.LEFT_RIGHT, colors
        )

        holder.view.background = gradientDrawable
    }

    override fun getItemCount(): Int = items.size
}
