package com.example.mealrecipe.view.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    val favoriteMeals = mealRepositoryImpl.getFavoriteMeals()

    fun putSelectedMealName(selectedMealName: String) {
        mealRepositoryImpl.putSelectedMealName(selectedMealName)
    }
}