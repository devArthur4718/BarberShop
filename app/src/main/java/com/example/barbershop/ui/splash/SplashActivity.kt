package com.example.barbershop.ui.splash

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.barbershop.R
import com.example.barbershop.ui.presentation.PresentationActivity

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.setBackgroundDrawable(ColorDrawable(resources.getColor(R.color.brown)))
        initViews()
    }

    private fun initViews() {
        Handler().postDelayed({
                startActivity(Intent(this,
                    PresentationActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }
}
