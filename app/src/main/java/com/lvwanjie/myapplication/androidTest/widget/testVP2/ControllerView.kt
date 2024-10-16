package com.lvwanjie.myapplication.androidTest.widget.testVP2

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout

class ControllerView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): View(context,attributes,def){


    override fun dispatchTouchEvent(event: MotionEvent?): Boolean {
        return super.dispatchTouchEvent(event)


    }
}