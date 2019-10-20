package com.example.copyproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvSimple.setOnClickListener {
            Intent(this, SimpleActivity::class.java).also {
                startActivity(it)
            }
        }

        tvGoogleDetail.setOnClickListener {

        }

        tvMaterialProfile.setOnClickListener {

        }

        tvFlexibleSpace.setOnClickListener {

        }

        tvSwipeExample.setOnClickListener {

        }
    }
}
