package com.lvwanjie.myapplication.androidTest.other.launchMode

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R


class TestLaunchModeActivity : AppCompatActivity() {
    
    
    companion object{
        const val TAG = "TestLaunchModeActivity.kt"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_launch_mode)
        val activityInfo = packageManager.getActivityInfo(
            componentName,
            PackageManager.GET_META_DATA
        )
        val taskAffinity = activityInfo.taskAffinity
        val taskId = taskId

        Log.i(TAG, "onCreate: $taskAffinity $taskId")
    }

    fun btClick(view: View){
        var intent:Intent = Intent(this,TestLaunchMode2Activity::class.java)
        startActivity(intent)
    }

    fun btClick2(view: View){
        var intent: Intent = Intent()
//        intent.setPackage("com.hengchang.kotlintest");
        intent.action = "testB"
        intent.data = Uri.parse("lwj://com.test.b/j")
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume: ")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause: ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy: ")
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        Log.i(TAG, "onNewIntent: ")
    }
}