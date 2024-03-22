package com.example.serulingemas.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.serulingemas.R
import com.example.serulingemas.databinding.ActivityInfoAplikasiBinding

private lateinit var binding: ActivityInfoAplikasiBinding

class infoAplikasiActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoAplikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgBackFromInfo.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.imgBackFromInfo -> {
                val intent = Intent()
                intent.putExtra("key", 1)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}