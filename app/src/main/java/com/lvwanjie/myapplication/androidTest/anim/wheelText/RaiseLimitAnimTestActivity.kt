package com.lvwanjie.myapplication.androidTest.anim.wheelText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lvwanjie.myapplication.R

class RaiseLimitAnimTestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raise_limit_anim_test)

    }

    private  val raiseLimitAnimWrapper:RaiseLimitAnimWrapper by lazy {
        RaiseLimitAnimWrapper(findViewById(R.id.card))
    }

    fun btClick(view: View){
        raiseLimitAnimWrapper.startAnim()
    }
}