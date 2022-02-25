package com.example.mealrecipe.view.recipe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.content.res.AppCompatResources
import com.bumptech.glide.Glide
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.R
import com.example.mealrecipe.data.local.MealEntity
import com.example.mealrecipe.databinding.ActivityRecipeViewBinding
import com.example.mealrecipe.model.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeView : BaseApplication() {
    lateinit var binding: ActivityRecipeViewBinding
    private val viewModel: RecipeViewModel by viewModels()
    lateinit var mealEntity: MealEntity
    lateinit var recipeDetail: Recipe
    lateinit var mealEntityList: List<MealEntity>
    var mealUId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        updateFavoriteMeal()
        configureRecipe()
        addToFavoriteList()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.help_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.help) {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(recipeDetail.youtube)))
        }
        return super.onOptionsItemSelected(item)
    }

    private fun addToFavoriteList() {
        binding.fabFavoriteRecipe.setOnClickListener {
            if (!isFavorite()) {
                binding.fabFavoriteRecipe.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.ic_dense_favorite
                    )
                )
                viewModel.addFavoriteMeal(mealEntity)
            } else {
                binding.fabFavoriteRecipe.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.ic_hollow_favorite
                    )
                )
                viewModel.deleteFavoriteMeal(mealEntity)
            }
        }
    }

    private fun updateFavoriteMeal() {
        viewModel.favoriteMeals.observe(this) {
            mealEntityList = it
            if (this::mealEntity.isInitialized) {
                mealEntity.id = getMealId()
            }
        }
    }

    private fun configureRecipe() {
        viewModel.recipeData.observe(this) { recipe ->
            recipeDetail = recipe.recipe[0]
            title = recipeDetail.name
            recipeDetail.thumb?.let { loadThumb(it) }
            binding.instructionDetails.text = recipeDetail.instruction
            binding.ingredientDetails.text = loadIngredients(recipeDetail)

            mealEntity =
                MealEntity(
                    mealUId,
                    meal = recipeDetail.name ?: "",
                    mealThumb = recipeDetail.thumb ?: ""
                )
            mealEntity.id = getMealId()

            if (isFavorite()) {
                binding.fabFavoriteRecipe.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.ic_dense_favorite
                    )
                )
            } else {
                binding.fabFavoriteRecipe.setImageDrawable(
                    AppCompatResources.getDrawable(
                        this,
                        R.drawable.ic_hollow_favorite
                    )
                )
            }
        }
    }

    private fun loadThumb(thumb: String) {
        Glide.with(this)
            .load(thumb)
            .into(binding.recipeThumb)
    }

    private fun loadIngredients(recipe: Recipe): String {
        val ingredientAndMeasurement = mapOf(
            recipe.strIngredient1 to recipe.strMeasure1,
            recipe.strIngredient2 to recipe.strMeasure2,
            recipe.strIngredient3 to recipe.strMeasure3,
            recipe.strIngredient4 to recipe.strMeasure4,
            recipe.strIngredient5 to recipe.strMeasure5,
            recipe.strIngredient6 to recipe.strMeasure6,
            recipe.strIngredient7 to recipe.strMeasure7,
            recipe.strIngredient8 to recipe.strMeasure8,
            recipe.strIngredient9 to recipe.strMeasure9,
            recipe.strIngredient10 to recipe.strMeasure10,
            recipe.strIngredient11 to recipe.strMeasure11,
            recipe.strIngredient12 to recipe.strMeasure12,
            recipe.strIngredient13 to recipe.strMeasure13,
            recipe.strIngredient14 to recipe.strMeasure14,
            recipe.strIngredient15 to recipe.strMeasure15,
            recipe.strIngredient16 to recipe.strMeasure16,
            recipe.strIngredient17 to recipe.strMeasure17,
            recipe.strIngredient18 to recipe.strMeasure18,
            recipe.strIngredient19 to recipe.strMeasure19,
            recipe.strIngredient20 to recipe.strMeasure20,
        )

        var ingredients = ""
        for (pair in ingredientAndMeasurement.entries) {
            if (pair.key.isNullOrEmpty()) {
                break
            }
            ingredients += "${pair.value} ${pair.key}  \n"
        }
        return ingredients
    }

    private fun isFavorite(): Boolean {
        mealEntityList.forEach {
            if (it.meal == recipeDetail.name) {
                return true
            }
        }
        return false
    }

    private fun getMealId(): Int {
        mealEntityList.forEach {
            if (it.meal == recipeDetail.name) {
                return it.id
            }
        }
        return 0
    }
}