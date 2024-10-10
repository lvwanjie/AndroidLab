package com.lvwanjie.myapplication.androidTest.widget.testTextView

import android.app.Dialog
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView

class MyTextView  @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): AppCompatTextView(context,attributes,def) {


    override fun onDraw(canvas: Canvas?) {

        var a = paint.measureText("你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好")
        var b = paint.measureText("你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好你好ssssssssssssssss")
        Log.i("MyTextView.kt", "onDraw: $a  ;; $b")
        super.onDraw(canvas)
        val paint = Paint()
        paint.textSize = 34f
        paint.textAlign = Paint.Align.LEFT
        paint.color = Color.RED
        canvas?.drawText("你好absflllllllllllllllkkkkkkkkfhskfhskhfkshkfhkshfkshfkskfh",0f,100f,paint)
    }



}