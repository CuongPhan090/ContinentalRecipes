package com.example.continentalrecipes.view.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.continentalrecipes.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    val selectedCategoryName = mealRepositoryImpl.getSelectedCategoryName()
    val mealData = liveData {
        emit(mealRepositoryImpl.getMeals(selectedCategoryName))
    }

    fun putSelectedMealName(selectedMealName: String) {
        mealRepositoryImpl.putSelectedMealName(selectedMealName)
    }
}
