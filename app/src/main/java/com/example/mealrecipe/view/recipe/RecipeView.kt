package com.example.mealrecipe.view.recipe

import android.os.Bundle
import androidx.activity.viewModels
import com.bumptech.glide.Glide
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.databinding.ActivityRecipeViewBinding
import com.example.mealrecipe.model.RecipeDetail
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeView : BaseApplication() {
    lateinit var binding: ActivityRecipeViewBinding
    private val viewModel: RecipeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        configureRecipe()
    }

    private fun configureRecipe() {
        viewModel.recipe.observe(this) { recipe ->
            val recipeDetail = recipe.recipeDetail[0]
            title = recipeDetail.name
            binding.instructionDetails.text = recipeDetail.instruction

            recipeDetail.thumb?.let { loadThumb(it) }
            binding.ingredientDetails.text = loadIngredients(recipeDetail)
        }
    }

    private fun loadThumb(thumb: String) {
        Glide.with(this)
            .load(thumb)
            .into(binding.recipeThumb)
    }

    private fun loadIngredients(recipeDetail: RecipeDetail): String {
        val ingredientAndMeasurement = mapOf(
            recipeDetail.strIngredient1 to recipeDetail.strMeasure1,
            recipeDetail.strIngredient2 to recipeDetail.strMeasure2,
            recipeDetail.strIngredient3 to recipeDetail.strMeasure3,
            recipeDetail.strIngredient4 to recipeDetail.strMeasure4,
            recipeDetail.strIngredient5 to recipeDetail.strMeasure5,
            recipeDetail.strIngredient6 to recipeDetail.strMeasure6,
            recipeDetail.strIngredient7 to recipeDetail.strMeasure7,
            recipeDetail.strIngredient8 to recipeDetail.strMeasure8,
            recipeDetail.strIngredient9 to recipeDetail.strMeasure9,
            recipeDetail.strIngredient10 to recipeDetail.strMeasure10,
            recipeDetail.strIngredient11 to recipeDetail.strMeasure11,
            recipeDetail.strIngredient12 to recipeDetail.strMeasure12,
            recipeDetail.strIngredient13 to recipeDetail.strMeasure13,
            recipeDetail.strIngredient14 to recipeDetail.strMeasure14,
            recipeDetail.strIngredient15 to recipeDetail.strMeasure15,
            recipeDetail.strIngredient16 to recipeDetail.strMeasure16,
            recipeDetail.strIngredient17 to recipeDetail.strMeasure17,
            recipeDetail.strIngredient18 to recipeDetail.strMeasure18,
            recipeDetail.strIngredient19 to recipeDetail.strMeasure19,
            recipeDetail.strIngredient20 to recipeDetail.strMeasure20,
        )

        var ingredients = ""
        for (pair  in ingredientAndMeasurement.entries) {
            if (pair.key.isNullOrEmpty()) {
                break
            }
            ingredients += "${pair.value} ${pair.key}  \n"
        }
        return ingredients
    }
}