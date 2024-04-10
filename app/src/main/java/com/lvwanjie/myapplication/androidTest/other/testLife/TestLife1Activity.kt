package com.lvwanjie.myapplication.androidTest.other.testLife

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lvwanjie.myapplication.R

class TestLife1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_life1_activty)
        Log.i(TestLife2Activity.TAG, "life1_onCreate: ")
    }

    fun btClick(view: View){
        var intent  = Intent(this,TestLife2Activity::class.java)
        startActivity(intent)
    }


    override fun onRestart() {

        super.onRestart()
        Log.i(TestLife2Activity.TAG, "life1_onRestart: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i(TestLife2Activity.TAG, "life1_onNewIntent: ")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TestLife2Activity.TAG, "life1_onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TestLife2Activity.TAG, "life1_onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TestLife2Activity.TAG, "life1_onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TestLife2Activity.TAG, "life1_onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TestLife2Activity.TAG, "life1_onDestroy: ")
    }
}