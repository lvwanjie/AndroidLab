package com.lvwanjie.myapplication.androidTest.other.aidltest

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Build
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.androidTest.other.aidltest.MyManagerService.Stub.TRANSACTION_getBookList

class TestAidlActivity : AppCompatActivity() {

    companion object{
        public const val TAG = "TestAidlActivity.kt"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_aidl)
        startService()

//        long a = 103208504534l;
//        System.out.println(getSegmentAmount(a));
//        System.out.println(NumberFormat.getInstance().format(a));
//        testFloat(null);
//        val INTERFACE_TRANSACTION =
//            '_'.code shl 24 or ('N'.code shl 16) or ('T'.code shl 8) or 'F'.code
//        var b = (TRANSACTION_getBookList == INTERFACE_TRANSACTION)
//        Log.i(TAG, "onCreate: $INTERFACE_TRANSACTION ; $b ")
    }

    private val conn by lazy {
        object:ServiceConnection{
            override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
                var list = MyManagerService.Stub.asInterface(service).bookList
                Log.i(TAG, "onServiceConnected: $service")
            }

            override fun onServiceDisconnected(name: ComponentName?) {
            }

        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startService(){
        var intent = Intent(this,TestAidlService::class.java)
        startForegroundService(intent)
        bindService(intent,conn, BIND_AUTO_CREATE)
    }

    override fun onDestroy() {
//        unbindService(conn)
        super.onDestroy()
    }
}