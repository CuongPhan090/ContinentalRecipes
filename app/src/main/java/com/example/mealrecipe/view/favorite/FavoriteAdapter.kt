package com.example.mealrecipe.view.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mealrecipe.databinding.FavoriteViewHolderBinding
import com.example.mealrecipe.model.MealDetail

class FavoriteAdapter: ListAdapter<MealDetail, FavoriteAdapter.FavoriteViewHolder>(FavoriteMealDiffCallBack()) {

    var onItemClickedListener: ((MealDetail) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener{
            onItemClickedListener(getItem(position))
        }
    }

    inner class FavoriteViewHolder(val binding: FavoriteViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(mealDetails: MealDetail) {
            binding.favoriteMealTitle.text = mealDetails.meal
            Glide.with(binding.root)
                .load(mealDetails.mealThumb)
                .into(binding.favoriteMealBackground)
        }
    }
}

class FavoriteMealDiffCallBack: DiffUtil.ItemCallback<MealDetail>() {
    override fun areItemsTheSame(oldItem: MealDetail, newItem: MealDetail): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: MealDetail, newItem: MealDetail): Boolean = oldItem == newItem

}