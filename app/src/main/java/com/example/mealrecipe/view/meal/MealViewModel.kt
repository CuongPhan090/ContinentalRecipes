package com.example.mealrecipe.view.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.mealrecipe.repository.MealRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(private val mealRepositoryImpl: MealRepositoryImpl): ViewModel() {

    private val selectedCategory = mealRepositoryImpl.getSelectedCategory()
    val meal = liveData {
        emit(mealRepositoryImpl.getMeals(selectedCategory))
    }

//    fun printStack() = mealRepositoryImpl.itemStack
}
