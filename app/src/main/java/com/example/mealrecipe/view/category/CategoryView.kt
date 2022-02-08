package com.example.mealrecipe.view.category

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.repository.MealRepositoryImpl
import com.example.mealrecipe.view.meal.MealView

class CategoryView() : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var adapter: CategoryAdapter
    private val categoryViewModel: CategoryViewModel by viewModels { CategoryViewModelFactory(
        MealRepositoryImpl(RemoteDataImpl())
    ) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configureCategoryView()
    }

    private fun configureCategoryView() {
        adapter = CategoryAdapter { categoryDetail ->
            categoryViewModel.putCategory(categoryDetail.category)
            startActivity(Intent(this, MealView::class.java))
        }

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter

        categoryViewModel.category.observe(this) {
            adapter.submitList(it.categories)
        }
    }
}
