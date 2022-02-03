package com.example.mealrecipe.view.meal

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealrecipe.databinding.MealViewHolderBinding
import com.example.mealrecipe.model.Meal

class MealViewHolder(private val binding: MealViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Meal) {
        binding.meal.text = item.meal
        Glide.with(binding.root)
            .load(item.mealThumb)
            .into(binding.mealBackground)
    }
}