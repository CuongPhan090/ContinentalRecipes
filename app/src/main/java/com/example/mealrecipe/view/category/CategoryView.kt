package com.example.mealrecipe.view.category

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.R
import com.example.mealrecipe.databinding.ActivityCategoryBinding
import com.example.mealrecipe.view.favorite.FavoriteView
import com.example.mealrecipe.view.meal.MealView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CategoryView : BaseApplication() {
    private lateinit var binding: ActivityCategoryBinding
    private lateinit var adapter: CategoryAdapter
    private val categoryViewModel: CategoryViewModel by viewModels()
    private lateinit var navigationView: NavigationView
    private lateinit var actionBarDrawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        createToolbar()
        setTitle()
        setupNavigationDrawer()
        configureCategoryView()
    }

    private fun setupNavigationDrawer() {
        navigationView = binding.myNavHostFragment
        navigationView.setNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item.itemId)
            // close navDrawer if it is opened
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }

        // Drawer toggle instance to open and close drawer button icon
        actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )

        // pass the Open and Close toggle for the drawer layout listener
        // to toggle the button
        binding.drawerLayout.addDrawerListener(actionBarDrawerToggle)
        // display drawer button icon
        actionBarDrawerToggle.syncState()

    }

    private fun onNavigationItemSelected(itemId: Int) {
        when (itemId) {
            R.id.menu_recipes -> startActivity(Intent(baseContext, CategoryView::class.java))
            R.id.menu_favourites -> startActivity(Intent(baseContext, FavoriteView::class.java))
            R.id.menu_rate ->
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://play.google.com/store/apps/details?id=com.supercell.clashofclans&hl=en_US&gl=US")
                    )
                )
            R.id.menu_shared -> startActivity(Intent.createChooser(Intent().apply {
                action = Intent.ACTION_SEND
                this.putExtra(
                    Intent.EXTRA_TEXT,
                    "Find diabetic food recipes for breakfast, lunch or dinner with complete details.\n\nTry now on this link:\n\nhttps://play.google.com/store/apps/details?id=com.supercell.clashofclans&hl=en_US&gl=US"
                )
                type = "text/plain"
            }, null))
            R.id.menu_about -> startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                this.data = Uri.parse("package:" + baseContext.packageName)
            })
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // open and close drawer icon if click
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setTitle() {
        title = "Recipe"
    }

    private fun configureCategoryView() {
        val recyclerView = binding.categoryRecyclerView
        adapter = CategoryAdapter()
        adapter.onCategoryClickListener = { categoryDetail ->
            categoryViewModel.putCategoryName(categoryDetail.category)
            startActivity(Intent(this, MealView::class.java)) }

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        categoryViewModel.categoryData.observe(this) {
            adapter.submitList(it.categories)
        }
    }


}


