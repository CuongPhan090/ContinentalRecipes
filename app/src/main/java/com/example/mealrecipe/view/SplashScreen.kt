package com.example.mealrecipe.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mealrecipe.databinding.ActivitySplashScreenBinding
import com.example.mealrecipe.view.category.CategoryView
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
//    lateinit var executorService: ScheduledExecutorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.tapToContinue.setOnClickListener {
            startActivity(Intent(this, CategoryView::class.java))
        }
//        executorService = Executors.newScheduledThreadPool(1)
//        val runnable = Runnable {
//            binding.tapToContinue.visibility = View.VISIBLE
//            Toast.makeText(this, "Ran 3 seconds", Toast.LENGTH_LONG).show()
//        }
//        executorService.schedule(
//            runnable,
//            3,
//            TimeUnit.SECONDS
//        )
    }
}