package com.lvwanjie.myapplication.kotlinTest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lvwanjie.myapplication.R

class TestKotlinActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kotlin)
    }

    fun testForEach(){
        var a = arrayOf(1,2,3)
        var array = a.forEachIndexed { index, i ->
            "a"
        }
        println(array)
        testFun {
            print("testFun")
        }

    }

    fun testFun(u:()->Unit){
        u
    }

    fun btClick(view: View){
        testForEach()
    }
}