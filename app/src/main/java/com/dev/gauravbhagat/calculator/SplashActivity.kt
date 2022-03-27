package com.dev.gauravbhagat.calculator

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var foregroundIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        foregroundIcon = findViewById(R.id.foregroundSplash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 1300)
    }

    override fun onStart() {
        super.onStart()

        supportActionBar?.hide()

        val animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in)
        foregroundIcon.startAnimation(animZoomIn)
    }
}