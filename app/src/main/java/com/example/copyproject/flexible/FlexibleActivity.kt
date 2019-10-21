package com.example.copyproject.flexible

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.copyproject.R
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_flexible.vAppBarLayout
import kotlinx.android.synthetic.main.activity_flexible.vToolbar
import kotlinx.android.synthetic.main.activity_profile.*
import kotlin.math.abs

class FlexibleActivity : AppCompatActivity() {

    companion object {
        private const val THRESHOLD = 20
    }

    private var isFabShown = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flexible)

        setSupportActionBar(vToolbar)
        setupFab()
    }

    private fun setupFab() {
        vAppBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScrollSize = appBarLayout.totalScrollRange
            val percentage = (abs(verticalOffset) * 100) / maxScrollSize
            hideFabAnimation(percentage)
            showFabAnimation(percentage)
        })
    }

    private fun showFabAnimation(percentage: Int) {
        if (percentage < THRESHOLD && !isFabShown) {
            isFabShown = true
            vFab.animate()
                .scaleX(1F)
                .scaleY(1F)
                .setDuration(200)
                .start()
        }
    }

    private fun hideFabAnimation(percentage: Int) {
        if (percentage >= THRESHOLD && isFabShown) {
            isFabShown = false
            vFab.animate()
                .scaleX(0F)
                .scaleY(0F)
                .setDuration(200)
                .start()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.simple_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_settings) {
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
