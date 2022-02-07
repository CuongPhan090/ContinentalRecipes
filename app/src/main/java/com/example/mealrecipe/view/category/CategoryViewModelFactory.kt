package com.example.mealrecipe.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealrecipe.repository.MealRepository
import java.lang.IllegalArgumentException

class CategoryViewModelFactory(private val mealRepository: MealRepository): ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CategoryViewModel::class.java))
            return CategoryViewModel(mealRepository) as T
        throw IllegalArgumentException("unknown viewmodel class")
    }
}