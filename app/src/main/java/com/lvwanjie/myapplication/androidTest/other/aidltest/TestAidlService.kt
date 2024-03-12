package com.lvwanjie.myapplication.androidTest.other.aidltest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TestAidlService : Service() {
    
    companion object{
        const val TAG = "TestAidlService.kt"
    }

    override fun onCreate() {
        Log.i(TAG, "onCreate: ")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand: ")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        Log.i(TAG, "onBind: $myBinder")
        return myBinder
    }

    override fun onRebind(intent: Intent?) {
        Log.i(TAG, "onRebind: $myBinder")
        super.onRebind(intent)
    }

    override fun onUnbind(intent: Intent?): Boolean {
        Log.i(TAG, "onUnbind: ")
        return true
    }

    override fun onDestroy() {
        Log.i(TAG, "onDestroy: ")
        super.onDestroy()
    }



    private val myBinder = object :MyManagerService.Stub(){
        override fun basicTypes(
            anInt: Int,
            aLong: Long,
            aBoolean: Boolean,
            aFloat: Float,
            aDouble: Double,
            aString: String?
        ) {

        }

        override fun getBookList(): MutableList<String> {
           var mutableList =  mutableListOf<String>()
            mutableList.add("a")
            mutableList.add("b")
            return mutableList
        }
    }
}