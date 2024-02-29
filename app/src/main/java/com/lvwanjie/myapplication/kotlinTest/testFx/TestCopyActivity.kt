package com.lvwanjie.myapplication.kotlinTest.testFx

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lvwanjie.myapplication.R

class TestCopyActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_copy)
    }


    fun testCopy(){

        var st1 = Student(1,"")
        var st2 = Student(2,"这是2")


    }

}