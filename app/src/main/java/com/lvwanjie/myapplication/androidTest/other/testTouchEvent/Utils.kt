package com.lvwanjie.myapplication.androidTest.other.testTouchEvent

import android.view.MotionEvent

fun getActionStr(action: Int): String? {
    var str = action.toString() + ""
    var a  = action and MotionEvent.ACTION_MASK
    when (a) {
        MotionEvent.ACTION_DOWN -> str = "ACTION_DOWN"
        MotionEvent.ACTION_UP -> str = "ACTION_UP"
        MotionEvent.ACTION_MOVE -> str = "ACTION_MOVE"
        MotionEvent.ACTION_CANCEL -> str = "ACTION_CANCEL"
        MotionEvent.ACTION_POINTER_DOWN -> str = "ACTION_POINTER_DOWN"
        MotionEvent.ACTION_POINTER_UP -> str = "ACTION_POINTER_UP"
        MotionEvent.ACTION_POINTER_1_DOWN -> str = "ACTION_POINTER_1_DOWN"
    }
    if(str != "ACTION_MOVE"){
        str = "=========$str ============"
    }
    return str
}