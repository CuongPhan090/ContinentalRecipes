package com.example.continentalrecipes.view.recipe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.continentalrecipes.data.local.MealEntity
import com.example.continentalrecipes.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    private val selectedMealName = mealRepositoryImpl.getSelectedMealName()
    val recipeData = liveData {
        emit(mealRepositoryImpl.getRecipe(selectedMealName))
    }

    val favoriteMeals = mealRepositoryImpl.getFavoriteMeals()

    fun addFavoriteMeal(favoriteMeal: MealEntity) {
        viewModelScope.launch {
            mealRepositoryImpl.putFavoriteMeal(favoriteMeal)
        }
    }

    fun deleteFavoriteMeal(favoriteMeal: MealEntity) {
        viewModelScope.launch {
            mealRepositoryImpl.deleteFavoriteMeal(favoriteMeal)
        }
    }
}
