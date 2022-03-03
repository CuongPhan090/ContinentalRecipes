package com.example.mealrecipe.view.favorite

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.databinding.ActivityFavoriteBinding
import com.example.mealrecipe.view.recipe.RecipeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteView : BaseApplication() {
    lateinit var binding: ActivityFavoriteBinding
    lateinit var adapter: FavoriteAdapter
    private val favoriteViewModel: FavoriteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        configureFavorite()
        handleClick()
    }

    private fun handleClick() {
        adapter.onItemClickedListener = {
            favoriteViewModel.putSelectedMealName(it.meal)
            startActivity(Intent(this, RecipeView::class.java))
        }
    }

    private fun configureFavorite() {
        binding.shimmerLayout.startShimmer()
        val recyclerView = binding.favoriteRecyclerView
        adapter = FavoriteAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        favoriteViewModel.favoriteMeals.observe(this) {
            adapter.submitList(it)
            binding.shimmerLayout.stopShimmer()
            binding.shimmerLayout.visibility = View.GONE
        }
    }
}