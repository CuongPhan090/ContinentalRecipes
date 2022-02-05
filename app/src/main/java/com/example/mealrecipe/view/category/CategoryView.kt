package com.example.mealrecipe.view.category

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.view.meal.MealView

class CategoryView : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var categoryViewModel: CategoryViewModel
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        categoryViewModel = ViewModelProviders.of(this).get(CategoryViewModel::class.java)
        categoryViewModel.getCategory()
        configureCategoryView()
    }

    private fun configureCategoryView() {
        adapter = CategoryAdapter {
            startActivity(Intent(this, MealView::class.java))
        }

        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter

        categoryViewModel.category.observe(this) {
            adapter.submitList(it.categories)
        }
    }
}
