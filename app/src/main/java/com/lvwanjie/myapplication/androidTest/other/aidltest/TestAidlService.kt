package com.lvwanjie.myapplication.androidTest.other.aidltest

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import android.view.ViewTreeObserver
import android.widget.Toast
import kotlin.math.log

class TestAidlService : Service() {
    
    companion object{
        const val TAG = "TestAidlService.kt"
    }

    override fun onCreate() {
        Log.i(TAG, "onCreate: ")
        Toast.makeText(applicationContext,"onCreate",Toast.LENGTH_LONG).show()
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.i(TAG, "onStartCommand: ")
        Toast.makeText(applicationContext, "service_start$packageName",Toast.LENGTH_LONG).show()
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

        override fun register(listener: IListener?) {
            listener?.listen("listen1")
            Log.i(TAG, "register:$listener")

        }

        override fun register2(listener: IListener?) {
            listener?.listen("listen2")
            Log.i(TAG, "register2:$listener")

        }


    }
}