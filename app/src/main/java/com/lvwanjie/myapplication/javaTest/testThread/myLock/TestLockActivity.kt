package com.lvwanjie.myapplication.javaTest.testThread.myLock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lvwanjie.myapplication.R

class TestLockActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_lock)
    }

    fun btClick(view: View){
        MyLockTest.testReentrantLock()
    }
}