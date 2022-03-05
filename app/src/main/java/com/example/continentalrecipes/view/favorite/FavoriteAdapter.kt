package com.example.continentalrecipes.view.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.continentalrecipes.data.local.MealEntity
import com.example.continentalrecipes.databinding.FavoriteViewHolderBinding

class FavoriteAdapter: ListAdapter<MealEntity, FavoriteAdapter.FavoriteViewHolder>(FavoriteMealDiffCallBack()) {

    var onItemClickedListener: ((MealEntity) -> Unit) = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder(FavoriteViewHolderBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.binding.root.setOnClickListener{
            onItemClickedListener(item)
        }
    }

    inner class FavoriteViewHolder(val binding: FavoriteViewHolderBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(mealDetails: MealEntity) {
            binding.favoriteMealTitle.text = mealDetails.meal
            Glide.with(binding.root)
                .load(mealDetails.mealThumb)
                .into(binding.favoriteMealBackground)
        }
    }
}

class FavoriteMealDiffCallBack: DiffUtil.ItemCallback<MealEntity>() {
    override fun areItemsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean = oldItem.meal == newItem.meal
    override fun areContentsTheSame(oldItem: MealEntity, newItem: MealEntity): Boolean = oldItem == newItem
}
