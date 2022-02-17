package com.example.mealrecipe.view.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.model.Meal
import com.example.mealrecipe.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    private val selectedMeal = mealRepositoryImpl.getSelectedMeal()
    val recipe = liveData {
        emit(mealRepositoryImpl.getRecipe(selectedMeal))
    }

    fun addFavoriteMeal(favoriteMeal: Meal) {
        mealRepositoryImpl.putFavoriteMeal(favoriteMeal)
    }

    fun remoteFavoriteMeal(favoriteMeal: Meal) {
        mealRepositoryImpl.removeFavoriteMeal(favoriteMeal)
    }
}