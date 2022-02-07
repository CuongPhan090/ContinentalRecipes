package com.example.mealrecipe.view.meal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealrecipe.model.MealDetail
import com.example.mealrecipe.network.ApiService
import kotlinx.coroutines.launch

class MealViewModel: ViewModel() {

    val mealDetail = MutableLiveData<MealDetail>()

}