package com.example.mealrecipe.view.splashscreen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mealrecipe.BaseApplication
import com.example.mealrecipe.databinding.ActivitySplashScreenBinding
import com.example.mealrecipe.view.category.CategoryView

@SuppressLint("CustomSplashScreen")
class SplashScreen : BaseApplication() {
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