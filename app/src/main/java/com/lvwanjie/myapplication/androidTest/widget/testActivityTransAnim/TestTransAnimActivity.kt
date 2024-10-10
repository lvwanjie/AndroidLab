package com.lvwanjie.myapplication.androidTest.widget.testActivityTransAnim

//import androidx.activity.enableEdgeToEdge
import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.transition.Slide
import android.transition.TransitionInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lvwanjie.myapplication.R


class TestTransAnimActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_test_trans_anim)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupWindowAnimations()
    }

    private fun setupWindowAnimations() {
//        val slide = TransitionInflater.from(this).inflateTransition(R.transition.my_fade)
//        window.exitTransition = slide
    }

    public fun jumpAnim2(view: View){
        val intent = Intent(this,TransAnim2Activity::class.java)
        val viewA= findViewById<View>(R.id.iv_abc)
        val option = ActivityOptions.makeSceneTransitionAnimation(this,viewA,"abc")
        startActivity(intent,option.toBundle())
    }
}