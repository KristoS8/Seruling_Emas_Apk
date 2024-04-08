package com.example.serulingemas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.serulingemas.Activity.LandingPageActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // hide action bar
        supportActionBar?.hide()
        // splash screen 2 sec
        Handler().postDelayed({
            startActivity(Intent(this@MainActivity, LandingPageActivity::class.java))
            finish()
        },2000)
    }
}