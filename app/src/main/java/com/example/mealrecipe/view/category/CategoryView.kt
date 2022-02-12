package com.example.mealrecipe.view.category

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.repository.MealRepositoryImpl
import com.example.mealrecipe.view.meal.MealView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CategoryView: AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var adapter: CategoryAdapter
    private val categoryViewModel: CategoryViewModel by viewModels()

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

        binding.categoryRecyclerView.adapter = adapter
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)

        categoryViewModel.category.observe(this) {
            adapter.submitList(it.categories)
        }
    }
}
