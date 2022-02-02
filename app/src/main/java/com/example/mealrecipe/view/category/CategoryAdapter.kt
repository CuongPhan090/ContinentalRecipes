package com.example.mealrecipe.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mealrecipe.databinding.CategoryViewHolderBinding
import com.example.mealrecipe.model.Category

class CategoryAdapter(private val categoryClickListener: CategoryClickListener): ListAdapter<Category, CategoryViewHolder>(CategoryDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(CategoryViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false), categoryClickListener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))

    }

    val clickListener = object : CategoryClickListener {
        override fun onCategoryClickListener(item: Category) {
            categoryClickListener.onCategoryClickListener(item)
        }
    }
}

class CategoryDiffCallback: DiffUtil.ItemCallback<Category>() {
    override fun areItemsTheSame(oldItem: Category, newItem: Category) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Category, newItem: Category) = oldItem == newItem
}