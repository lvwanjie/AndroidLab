package com.lvwanjie.myapplication.androidTest.widget.testFlexBox

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.flexbox.FlexboxLayout
import com.lvwanjie.myapplication.R

class TestFlexboxActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestFlexboxActivity.kt"
    }
    private val flexBox :FlexboxLayout by lazy {
        findViewById(R.id.flex_box)
    }
    private val customExpandFlowLayout:ExpandFlowLayout by lazy {
        findViewById(R.id.my_expand_flow_layout)
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
        for(i in 0..20){
            val item = LayoutInflater.from(this).inflate(R.layout.item_flex_box,flexBox,false)
            var params = item.layoutParams
            params.width = 100 + (0..100).random()
            customExpandFlowLayout.addView(item,params)
        }
        val lastView = LayoutInflater.from(this).inflate(R.layout.item_flex_last,flexBox,false)
        customExpandFlowLayout.setLastView(lastView)
//        customExpandFlowLayout.setexpandableLine(2)
    }

    private var flag = false
    fun expand(view:View){
        flag = !flag
        if(flag){
            customExpandFlowLayout.setExpand(true)
        }else{
            customExpandFlowLayout.setExpand(false)
        }
    }

    public fun test1(){
        var start = 0
        var end = 10
        var index = 0;
        while (start <= end){
            index ++
            Log.i(TAG, "test1: $start  ;$index")
            start++
            if(start == 9){
                start = 3
                end = 6
            }
        }
    }
}