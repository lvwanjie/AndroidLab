package com.lvwanjie.myapplication.androidTest.other.launchMode

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.lvwanjie.myapplication.R

class TestLaunchMode3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_launch_mode3)

        val activityInfo = packageManager.getActivityInfo(
            componentName,
            PackageManager.GET_META_DATA
        )
        val taskAffinity = activityInfo.taskAffinity
        val taskId = taskId

        Log.i("TestLaunchModeActivity.kt", "onCreate_mode_3: $taskAffinity $taskId")
    }


}