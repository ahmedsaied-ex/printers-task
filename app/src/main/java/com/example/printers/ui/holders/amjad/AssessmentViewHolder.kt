package com.example.printers.ui.holders.amjad

import androidx.recyclerview.widget.RecyclerView
import com.example.printers.databinding.AssesmentCardLayoutBinding

class AssessmentViewHolder(val binding: AssesmentCardLayoutBinding) :
    RecyclerView.ViewHolder(binding.root){
       val img= binding.ivAssessementImg
    val headText=binding.tvAssessmentHead
    val view=binding.gradView
    }