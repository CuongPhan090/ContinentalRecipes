package com.example.mealrecipe.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealrecipe.databinding.CategoryViewHolderBinding
import com.example.mealrecipe.model.CategoryDetail

class CategoryAdapter: ListAdapter<CategoryDetail, CategoryAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    var onCategoryClickListener: (CategoryDetail) -> Unit = { _: CategoryDetail -> }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            CategoryViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener {
            onCategoryClickListener(getItem(position))
        }
    }

    inner class CategoryViewHolder(val binding: CategoryViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoryDetail) {
            binding.category.text = item.category
            Glide.with(binding.root)
                .load(item.categoryThumb)
                .into(binding.categoryBackground)

        }
    }

}

class CategoryDiffCallback : DiffUtil.ItemCallback<CategoryDetail>() {
    override fun areItemsTheSame(oldItem: CategoryDetail, newItem: CategoryDetail) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: CategoryDetail, newItem: CategoryDetail) = oldItem == newItem
}
