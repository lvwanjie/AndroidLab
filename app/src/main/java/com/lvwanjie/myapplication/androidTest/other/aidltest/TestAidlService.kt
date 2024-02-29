package com.lvwanjie.myapplication.androidTest.other.aidltest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class TestAidlService : Service() {

    override fun onBind(intent: Intent): IBinder {
        Log.i("TestAidlService", "onStartCommand: $myBinder")
        return myBinder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
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