package com.example.mealrecipe.view.meal

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mealrecipe.repository.MealRepositoryImpl
import java.lang.IllegalArgumentException

class MealViewModelFactory(private val mealRepositoryImpl: MealRepositoryImpl): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MealViewModel::class.java))
            return MealViewModel(mealRepositoryImpl) as T
        throw IllegalArgumentException("unknown viewmodel class")
    }
}