package com.example.mealrecipe.view.category

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipe.model.Category
import com.example.mealrecipe.network.ApiService
import kotlinx.coroutines.launch

class CategoryViewModel: ViewModel() {
    val category = MutableLiveData<Category>()

    fun getCategory() {
        viewModelScope.launch {
            val result = ApiService.categoryApi.getCategory()
            category.value = result
        }
    }

}