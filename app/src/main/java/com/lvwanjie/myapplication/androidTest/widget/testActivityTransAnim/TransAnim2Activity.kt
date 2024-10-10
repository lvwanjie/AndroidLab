package com.lvwanjie.myapplication.androidTest.widget.testActivityTransAnim

import android.os.Bundle
import android.transition.Slide
import android.transition.Transition
import android.transition.TransitionInflater
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lvwanjie.myapplication.R

class TransAnim2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trans_anim2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
        val slide: Slide = TransitionInflater.from(this).inflateTransition(R.transition.my_slide) as Slide
        slide.slideEdge = Gravity.END
        window.enterTransition = slide
    }
}