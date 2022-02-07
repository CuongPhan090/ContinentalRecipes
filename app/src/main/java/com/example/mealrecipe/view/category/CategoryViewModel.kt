package com.example.mealrecipe.view.category

import androidx.lifecycle.*
import com.example.mealrecipe.model.Category
import com.example.mealrecipe.network.ApiService
import com.example.mealrecipe.repository.MealRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class CategoryViewModel(
    private val mealRepository: MealRepository
): ViewModel() {
    val category = liveData {
        emit(mealRepository.getCategory())
    }

}