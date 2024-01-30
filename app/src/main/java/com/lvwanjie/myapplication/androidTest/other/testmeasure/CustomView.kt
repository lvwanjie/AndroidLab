package com.lvwanjie.myapplication.androidTest.other.testmeasure

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatTextView

open class CustomView @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): AppCompatTextView(context,attributes,def){

    companion object{
        const val TAG= "CustomView.kt"
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {

        var widthSpecMode = MeasureSpec.getMode(widthMeasureSpec) ushr 30
        var heightSpecMode = MeasureSpec.getMode(heightMeasureSpec) ushr 30
        var widthSize = MeasureSpec.getSize(widthMeasureSpec)
        var heightSize = MeasureSpec.getSize(heightMeasureSpec)
        Log.i(TAG, "$text ===onMeasure:" +
                " widthSpecMode:${widthSpecMode} " +
                ";heightSpecMode:$heightSpecMode " +
                ";widthSize:$widthSize ;" +
                "heightSize:$heightSize")
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}