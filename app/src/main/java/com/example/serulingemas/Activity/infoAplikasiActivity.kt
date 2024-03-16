package com.example.serulingemas.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.serulingemas.R
import com.example.serulingemas.databinding.ActivityInfoAplikasiBinding

private lateinit var binding: ActivityInfoAplikasiBinding

class infoAplikasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoAplikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}