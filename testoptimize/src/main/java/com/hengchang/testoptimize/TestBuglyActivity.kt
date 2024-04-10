package com.hengchang.testoptimize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.tencent.bugly.crashreport.CrashReport

class TestBuglyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_bugly)
    }


    fun btClick(view: View){
        CrashReport.testJavaCrash();
    }
}