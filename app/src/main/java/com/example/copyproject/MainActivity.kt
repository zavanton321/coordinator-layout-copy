package com.example.copyproject

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        onSimpleClick()
        onGoogleDetailClick()
        onMaterialClick()
        onFlexibleClick()
        onSwipeClick()
    }

    private fun onSimpleClick() {
        tvSimple.setOnClickListener {
            Intent(this, SimpleActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun onGoogleDetailClick() {
        tvGoogleDetail.setOnClickListener {
            Intent(this, GoogleDetailActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun onMaterialClick() {
        tvMaterialProfile.setOnClickListener {
            Intent(this, ProfileActivity::class.java).also {
                startActivity(it)
            }
        }
    }

    private fun onFlexibleClick() {
        tvFlexibleSpace.setOnClickListener {

        }
    }

    private fun onSwipeClick() {
        tvSwipeExample.setOnClickListener {

        }
    }
}
