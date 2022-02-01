package com.example.mealrecipe.view.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.ActivityCategoryBinding

class CategoryView : AppCompatActivity() {
    lateinit var binding: ActivityCategoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // create some dummy data and submit the list
    }
}