package com.example.continentalrecipes.view.favorite

import androidx.lifecycle.ViewModel
import com.example.continentalrecipes.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    val favoriteMeals = mealRepositoryImpl.getFavoriteMeals()

    fun putSelectedMealName(selectedMealName: String) {
        mealRepositoryImpl.putSelectedMealName(selectedMealName)
    }
}