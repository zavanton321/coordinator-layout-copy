package com.example.copyproject.swipe

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.copyproject.R
import com.google.android.material.behavior.SwipeDismissBehavior
import kotlinx.android.synthetic.main.activity_swipe.*

class SwipeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_swipe)

        val swipeDismissBehavior = SwipeDismissBehavior<CardView>()
        swipeDismissBehavior.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END)
        swipeDismissBehavior.setListener(object : SwipeDismissBehavior.OnDismissListener {

            override fun onDismiss(view: View?) {
                Toast.makeText(this@SwipeActivity, "Swiped", Toast.LENGTH_SHORT).show()
            }

            override fun onDragStateChanged(state: Int) {
            }
        })

        val params = vCardView.layoutParams as CoordinatorLayout.LayoutParams
        params.behavior = swipeDismissBehavior
    }
}
