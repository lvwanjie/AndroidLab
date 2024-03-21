package com.lvwanjie.myapplication.androidTest.other.testTouchEvent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.lvwanjie.myapplication.R

class TestTouchEventActivity : FragmentActivity() {

    companion object{
        const val TAG = "TestTouchEventActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_touch_event)

        Thread({}).start()
        Thread(Runnable {  }).start()
    }
}