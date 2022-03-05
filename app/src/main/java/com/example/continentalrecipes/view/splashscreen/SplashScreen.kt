package com.example.continentalrecipes.view.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import com.example.continentalrecipes.BaseApplication
import com.example.continentalrecipes.databinding.ActivitySplashScreenBinding
import com.example.continentalrecipes.view.category.CategoryView

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseApplication() {
    lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val animation = AlphaAnimation(0f, 1f).apply {
            duration = 5000
        }
        animation.setAnimationListener(object: Animation.AnimationListener{
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                binding.tapToContinue.visibility = View.VISIBLE
            }
        })
        binding.logo.startAnimation(animation)

        binding.tapToContinue.setOnClickListener {
            startActivity(Intent(this, CategoryView::class.java))
        }
    }
}