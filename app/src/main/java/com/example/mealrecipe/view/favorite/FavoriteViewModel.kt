package com.example.mealrecipe.view.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavoriteActivityViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    val favoriteMeals = liveData {
        emit(mealRepositoryImpl.getFavoriteMeals())
    }
}