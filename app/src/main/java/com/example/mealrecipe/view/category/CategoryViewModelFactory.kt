package com.example.mealrecipe.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealrecipe.repository.MealRepositoryImpl
import java.lang.IllegalArgumentException

    class CategoryViewModelFactory(private val mealRepositoryImpl: MealRepositoryImpl): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CategoryViewModel::class.java))
                return CategoryViewModel(mealRepositoryImpl) as T
            throw IllegalArgumentException("unknown viewmodel class")
        }
    }