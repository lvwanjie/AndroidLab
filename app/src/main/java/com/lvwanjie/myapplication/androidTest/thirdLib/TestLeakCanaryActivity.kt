package com.lvwanjie.myapplication.androidTest.thirdLib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lvwanjie.myapplication.R
import java.lang.ref.WeakReference

class TestLeakCanaryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_leak_canary)
    }


    fun testWeakReference(){
       var r =  WeakReference("")
    }
}