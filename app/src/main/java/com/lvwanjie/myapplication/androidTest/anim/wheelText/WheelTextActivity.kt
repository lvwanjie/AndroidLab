package com.lvwanjie.myapplication.androidTest.anim.wheelText

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lvwanjie.myapplication.R

class WheelTextActivity : AppCompatActivity() {

    private lateinit var wheelTextVIew: WheelTextVIew;
    private lateinit var floatTextView: FloatTextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wheel_text)
        wheelTextVIew = findViewById(R.id.wheel_textView);
        floatTextView = findViewById(R.id.float_text_view)
    }


    fun btClick(view: View){
        wheelTextVIew.setText(100,1000)
        floatTextView.setData("abc")
    }
}