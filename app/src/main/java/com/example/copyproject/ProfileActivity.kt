package com.example.copyproject

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.activity_profile.*
import kotlin.math.abs

class ProfileActivity : AppCompatActivity() {

    private var isAvatarShown = false

    companion object {

        private const val THRESHOLD = 20
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setupUI()
    }

    private fun setupUI() {
        setupToolbar()
        setupTabs()
        setupAvatar()
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

    private fun setupToolbar() {
        setSupportActionBar(vToolbar)
        vToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun setupTabs() {
        vViewPager.adapter = CustomAdapter(supportFragmentManager)
        vTabLayout.setupWithViewPager(vViewPager)
    }

    private fun setupAvatar() {
        vAppBarLayout.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout, verticalOffset ->
            val maxScrollSize = appBarLayout.totalScrollRange
            val percentage = (abs(verticalOffset) * 100) / maxScrollSize
            hideAvatarAnimation(percentage)
            showAvatarAnimation(percentage)
        })
    }

    private fun showAvatarAnimation(percentage: Int) {
        if (percentage < THRESHOLD && !isAvatarShown) {
            isAvatarShown = true
            vCircleImageView.animate()
                .scaleX(1F)
                .scaleY(1F)
                .setDuration(200)
                .start()
        }
    }

    private fun hideAvatarAnimation(percentage: Int) {
        if (percentage >= THRESHOLD && isAvatarShown) {
            isAvatarShown = false
            vCircleImageView.animate()
                .scaleX(0F)
                .scaleY(0F)
                .setDuration(200)
                .start()
        }
    }

    class CustomAdapter(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

        companion object {
            private const val NUM_OF_FRAGMENTS = 2
        }

        override fun getItem(position: Int): Fragment = PlaceHolderFragment.newInstance()

        override fun getCount(): Int = NUM_OF_FRAGMENTS

        override fun getPageTitle(position: Int): CharSequence? = "Fragment $position"
    }
}
