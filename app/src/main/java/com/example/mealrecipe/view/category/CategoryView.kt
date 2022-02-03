package com.example.mealrecipe.view.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.model.Category

class CategoryView : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding
    lateinit var adapter: CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureCategoryView()
    }

    private fun configureCategoryView() {
        adapter = CategoryAdapter { category ->
            Toast.makeText(this, "$category", Toast.LENGTH_LONG).show()
        }
        binding.categoryRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.categoryRecyclerView.adapter = adapter

        // create some dummy data
        val categoryList = listOf(
            Category("1","Beef", "https://www.themealdb.com/images/category/beef.png"),
            Category("2","Pork", "https://www.themealdb.com/images/category/pork.png"),
            Category("3","Chicken", "https://www.themealdb.com/images/category/chicken.png"),
            Category("4","Lamb", "https://www.themealdb.com/images/category/lamb.png"),
            Category("5","Beef", "https://www.themealdb.com/images/category/beef.png")
        )

        adapter.submitList(categoryList)
    }
}