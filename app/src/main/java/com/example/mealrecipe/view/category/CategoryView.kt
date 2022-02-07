package com.example.mealrecipe.view.category

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.network.ApiClient
import com.example.mealrecipe.repository.MealRepository
import com.example.mealrecipe.view.meal.MealView

class CategoryView() : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var adapter: CategoryAdapter
    private val categoryViewModel: CategoryViewModel by viewModels { CategoryViewModelFactory(MealRepository()) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureCategoryView()
    }

    private fun configureCategoryView() {
        // need to refactor this click handling
        adapter = CategoryAdapter { categoryDetail ->
            startActivity(Intent(this, MealView::class.java).also {
                it.putExtra("category", categoryDetail)
            })
        }

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter

        categoryViewModel.category.observe(this) {
            adapter.submitList(it.categories)
        }

    }
}
