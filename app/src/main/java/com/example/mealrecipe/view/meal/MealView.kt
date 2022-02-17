package com.example.mealrecipe.view.meal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.data.RemoteDataImpl
import com.example.mealrecipe.databinding.ActivityMealViewBinding
import com.example.mealrecipe.repository.MealRepositoryImpl
import com.example.mealrecipe.view.recipe.RecipeView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MealView: BaseApplication() {
    lateinit var binding: ActivityMealViewBinding
    lateinit var adapter: MealAdapter
    private val mealViewModel: MealViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMealViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        title = mealViewModel.selectedCategory
        configureMeal()
    }


    private fun configureMeal() {
        adapter = MealAdapter {
            mealViewModel.putSelectedMeal(it.meal)
            startActivity(Intent(this, RecipeView::class.java))
        }
        binding.mealRecyclerView.adapter = adapter
        binding.mealRecyclerView.layoutManager = LinearLayoutManager(this)

        mealViewModel.meal.observe(this) { mealDetail ->
            adapter.submitList(mealDetail.meals)
        }
    }
}
