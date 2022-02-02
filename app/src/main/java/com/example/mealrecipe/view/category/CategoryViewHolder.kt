package com.example.mealrecipe.view.category

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.CategoryViewHolderBinding
import com.example.mealrecipe.model.Category

// Contain the metadata of category from a list of categories
class CategoryViewHolder(
    private val binding: CategoryViewHolderBinding,
    private val categoryClickListener: CategoryClickListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(item: Category) {
        binding.category.text = item.category
        Glide.with(binding.root)
            .load(item.categoryThumb)
            .into(binding.categoryBackground)

        itemView.setOnClickListener {
            categoryClickListener.onCategoryClickListener(item)
        }
    }
}