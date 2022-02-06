package com.example.mealrecipe.view.meal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.ActivityMealViewBinding
import com.example.mealrecipe.model.CategoryDetail
import com.example.mealrecipe.model.Meal

class MealView : AppCompatActivity() {
    lateinit var binding: ActivityMealViewBinding
    lateinit var adapter: MealAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureMeal()
    }

    private fun configureMeal() {
        val selectedCategory = intent.getParcelableExtra<CategoryDetail>("category")
        adapter = MealAdapter()
        binding.mealRecyclerView.adapter = adapter
        binding.mealRecyclerView.layoutManager = LinearLayoutManager(this)
        Toast.makeText(this, "$selectedCategory", Toast.LENGTH_LONG).show()

        // Create some dummy list
        val meals = listOf(
            Meal("1", "Kapsalon", "https://www.themealdb.com/images/media/meals/sxysrt1468240488.jpg"),
            Meal("1", "Kapsalon", "https://www.themealdb.com/images/media/meals/sxysrt1468240488.jpg"),
            Meal("1", "Kapsalon", "https://www.themealdb.com/images/media/meals/sxysrt1468240488.jpg"),
            Meal("1", "Kapsalon", "https://www.themealdb.com/images/media/meals/sxysrt1468240488.jpg")
        )
        adapter.submitList(meals)
    }
}