package com.lvwanjie.myapplication.androidTest.other.launchMode

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R

class TestLaunchMode2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_launch_mode2)

        val activityInfo = packageManager.getActivityInfo(
            componentName,
            PackageManager.GET_META_DATA
        )
        val taskAffinity = activityInfo.taskAffinity
        val taskId = taskId

        Log.i("TestLaunchModeActivity.kt", "onCreate_mode_2: $taskAffinity $taskId")
    }

    fun btClick(view: View){
        var intent: Intent = Intent(this,TestLaunchMode3Activity::class.java)
        startActivity(intent)
    }
}