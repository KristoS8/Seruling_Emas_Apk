package com.example.serulingemas.Activity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.serulingemas.R
import com.example.serulingemas.databinding.ActivityDetailLaguBinding

private lateinit var binding: ActivityDetailLaguBinding

class detailLaguActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLaguBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bundle = intent.extras

        binding.tvjudullagudetail.text = bundle?.getString("judulLagu")
        binding.tvdeskripsidetail.text = bundle?.getString("deskripsiLagu")
        binding.tvisidetail.text = bundle?.getString("isiLagu")

        binding.imgBack.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.imgBack -> {
                val intent = Intent()
                intent.putExtra("key", 1)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}