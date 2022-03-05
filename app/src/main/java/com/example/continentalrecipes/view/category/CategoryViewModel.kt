package com.example.continentalrecipes.view.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.continentalrecipes.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val mealRepositoryImpl: MealRepositoryImpl
): ViewModel() {
    val categoryData = liveData {
        emit(mealRepositoryImpl.getCategories())
    }

    fun putCategoryName(categoryName: String) = mealRepositoryImpl.putSelectedCategoryName(categoryName)
}