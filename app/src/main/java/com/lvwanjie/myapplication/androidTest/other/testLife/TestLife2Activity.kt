package com.lvwanjie.myapplication.androidTest.other.testLife

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lvwanjie.myapplication.R

class TestLife2Activity : AppCompatActivity() {
    companion object {
        const val TAG = "TestLifeActivity.kt"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_life2)
        Log.i(TAG, "life2_onCreate: ")
    }

    fun btClick(view: View){
        var intent  = Intent(this,TestLife1Activity::class.java)
        startActivity(intent)
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "life2_onRestart: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "life2_onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "life2_onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "life2_onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "life2_onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "life2_onDestroy: ")
    }
}