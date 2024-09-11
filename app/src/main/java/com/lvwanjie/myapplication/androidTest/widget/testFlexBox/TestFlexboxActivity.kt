package com.lvwanjie.myapplication.androidTest.widget.testFlexBox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.flexbox.FlexboxLayout
import com.lvwanjie.myapplication.R

class TestFlexboxActivity : AppCompatActivity() {

    private val flexBox :FlexboxLayout by lazy {
        findViewById(R.id.flex_box)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flexbox)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    public fun btClick(view: View){
        var view = LayoutInflater.from(this).inflate(R.layout.item_flex_box,flexBox,false)
        flexBox.addView(view)
//        flexBox.set
    }
}