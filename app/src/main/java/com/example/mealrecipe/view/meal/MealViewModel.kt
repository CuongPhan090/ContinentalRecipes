package com.example.mealrecipe.view.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.repository.MealRepository
import com.example.mealrecipe.repository.MealRepositoryImpl

class MealViewModel(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    private val selectedCategory = mealRepositoryImpl.getSelectedCategory()
    val meal = liveData {
        emit(mealRepositoryImpl.getMeals(selectedCategory))
    }

    fun printStack() = mealRepositoryImpl.itemStack
}
