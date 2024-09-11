package com.lvwanjie.myapplication.androidTest.widget.testFlexBox

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.google.android.flexbox.FlexboxLayout
import kotlin.math.max

class CustomExpandFlowLayout@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): LinearLayout(context,attributes,def) {

    private var lastView:View? = null
    private fun setLastView(view: View){
        this.addView(lastView)
        this.lastView =  view
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {

        var line = 0
        var curLeft = l
        var curTop = t
        var maxWith = measuredWidth - paddingStart - paddingEnd
        for(i in 0..childCount){
            val curView = getChildAt(0)
            var childRight = curLeft + curView.measuredWidth
            var childBottom = curTop + curView.measuredHeight
            curView.layout(curLeft, curTop, childRight, childBottom)
            curLeft = childRight
//            if()
//            if(maxWith){
//
//            }



        }
    }


}