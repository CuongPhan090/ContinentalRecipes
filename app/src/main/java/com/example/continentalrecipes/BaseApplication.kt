package com.example.continentalrecipes

import androidx.appcompat.app.AppCompatActivity

/**
 * Common functionality across activity
 */
open class BaseApplication: AppCompatActivity() {
    fun createToolbar() {
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}