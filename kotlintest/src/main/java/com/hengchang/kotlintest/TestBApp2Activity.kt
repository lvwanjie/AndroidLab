package com.hengchang.kotlintest

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class TestBApp2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_bapp2)

        val activityInfo = packageManager.getActivityInfo(
            componentName,
            PackageManager.GET_META_DATA
        )
        val taskAffinity = activityInfo.taskAffinity
        val taskId = taskId

        Log.i("TestLaunchModeActivity.kt", "onCreate_testB_2: $taskAffinity $taskId")
    }
}