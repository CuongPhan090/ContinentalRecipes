package com.example.mealrecipe.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.repository.MealRepositoryImpl

class CategoryViewModel(
    private val mealRepositoryImpl: MealRepositoryImpl
): ViewModel() {
    val category = liveData {
        emit(mealRepositoryImpl.getCategories())
    }

    fun putCategory(category: String) = mealRepositoryImpl.putSelectedCategory(category)

    fun printStack() = mealRepositoryImpl.itemStack
}