package com.example.mealrecipe.view.meal

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealrecipe.databinding.MealViewHolderBinding
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.model.MealDetail

class MealAdapter: ListAdapter<MealDetail, MealAdapter.MealViewHolder>(MealDetailDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(MealViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MealViewHolder(private val binding: MealViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MealDetail) {
            binding.meal.text = item.meal
            Glide.with(binding.root)
                .load(item.mealThumb)
                .into(binding.mealBackground)
        }
    }
}

class MealDetailDiffCallback: DiffUtil.ItemCallback<MealDetail>() {
    override fun areItemsTheSame(oldItem: MealDetail, newItem: MealDetail) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: MealDetail, newItem: MealDetail) = oldItem == newItem
}

