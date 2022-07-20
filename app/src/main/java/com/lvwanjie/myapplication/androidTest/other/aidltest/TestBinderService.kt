package com.lvwanjie.myapplication.androidTest.other.aidltest

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.os.Parcel
import android.util.Log


/**
 * 手写binder 通信 不用aidl
 */

class TestBinderService : Service() {
    companion object{
        const val TAG = "TestBinderService"
    }

    override fun onBind(intent: Intent): IBinder {
        return myBinder
    }

    private var myBinder = object :Binder(){


        /**
         * data 获取传来的数据
         * reply 回复
         */
        override fun onTransact(code: Int, data: Parcel, reply: Parcel?, flags: Int): Boolean {
            Log.i(TAG, "onTransact: ")
            return super.onTransact(code, data, reply, flags)

        }

    }
}