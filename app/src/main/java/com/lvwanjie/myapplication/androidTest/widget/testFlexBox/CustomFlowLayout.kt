package com.lvwanjie.myapplication.androidTest.widget.testFlexBox

import android.content.Context
import android.util.AttributeSet
import android.view.View
import com.google.android.flexbox.FlexboxLayout

class CustomFlowLayout@JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
):FlexboxLayout(context,attributes,def) {

    private var maxLine:Int = -1;


    private fun setLastView(view: View){

    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)


    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {

        if(maxLine <=0 ){
            super.onLayout(changed, left, top, right, bottom)
        } else {
            layoutWithMaxLine()
        }
    }

    private fun layoutWithMaxLine(){

        for(flexLine in flexLines){



        }
    }


}