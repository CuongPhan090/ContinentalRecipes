package com.example.mealrecipe.view.meal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.databinding.ActivityMealViewBinding
import com.example.mealrecipe.repository.MealRepositoryImpl

class MealView : AppCompatActivity() {
    lateinit var binding: ActivityMealViewBinding
    lateinit var adapter: MealAdapter
    private val mealViewModel: MealViewModel by viewModels{ MealViewModelFactory(
        MealRepositoryImpl(RemoteDataImpl())
    )}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configureMeal()
    }

    private fun configureMeal() {
        adapter = MealAdapter()
        binding.mealRecyclerView.adapter = adapter
        binding.mealRecyclerView.layoutManager = LinearLayoutManager(this)

        mealViewModel.meal.observe(this) { mealDetail ->
            adapter.submitList(mealDetail.meals)
        }
    }
}
