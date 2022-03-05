package com.example.continentalrecipes.view.meal

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.continentalrecipes.databinding.MealViewHolderBinding
import com.example.continentalrecipes.model.Meal

class MealAdapter(
    val onMealClickListener: ((Meal) -> Unit)
) : ListAdapter<Meal, MealAdapter.MealViewHolder>(MealDetailDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            MealViewHolderBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.root.setOnClickListener {
            onMealClickListener(getItem(position))
        }
    }

    inner class MealViewHolder(val binding: MealViewHolderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Meal) {
            binding.mealTitle.text = item.meal
            binding.shimmerLayout.startShimmer()

            Glide.with(binding.root)
                .load(item.mealThumb)
                .listener(object: RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        binding.mealTitle.visibility = View.VISIBLE
                        binding.shimmerLayout.stopShimmer()
                        binding.shimmerLayout.visibility = View.GONE
                        return false
                    }
                })
                .into(binding.mealBackground)
        }
    }
}

class MealDetailDiffCallback : DiffUtil.ItemCallback<Meal>() {
    override fun areItemsTheSame(oldItem: Meal, newItem: Meal) =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: Meal, newItem: Meal) = oldItem == newItem
}

