package com.example.mealrecipe.view.meal

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.databinding.ActivityMealViewBinding
import com.example.mealrecipe.view.recipe.RecipeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealView: BaseApplication() {
    lateinit var binding: ActivityMealViewBinding
    lateinit var adapter: MealAdapter
    private val mealViewModel: MealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        title = mealViewModel.selectedCategoryName
        configureMeal()
    }


    private fun configureMeal() {
        adapter = MealAdapter {
            mealViewModel.putSelectedMealName(it.meal)
            startActivity(Intent(this, RecipeView::class.java))
        }
        binding.mealRecyclerView.adapter = adapter
        binding.mealRecyclerView.layoutManager = LinearLayoutManager(this)

        mealViewModel.mealData.observe(this) { mealDetail ->
            adapter.submitList(mealDetail.meals)
        }
    }
}
