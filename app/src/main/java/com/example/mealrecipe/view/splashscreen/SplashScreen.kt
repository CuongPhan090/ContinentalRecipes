package com.example.mealrecipe.view.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.TransitionDrawable
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.appcompat.app.AppCompatActivity
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.databinding.ActivitySplashScreenBinding
import com.example.mealrecipe.view.category.CategoryView

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