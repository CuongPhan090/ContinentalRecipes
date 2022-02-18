package com.example.mealrecipe.view.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.model.MealDetail
import com.example.mealrecipe.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    private val selectedMealName = mealRepositoryImpl.getSelectedMealName()
    val recipeData = liveData {
        emit(mealRepositoryImpl.getRecipe(selectedMealName))
    }

    fun addFavoriteMeal(favoriteMeal: MealDetail) {
        mealRepositoryImpl.putFavoriteMeal(favoriteMeal)
    }

    fun remoteFavoriteMeal(favoriteMeal: MealDetail) {
        mealRepositoryImpl.removeFavoriteMeal(favoriteMeal)
    }
}