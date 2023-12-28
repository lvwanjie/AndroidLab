package com.lvwanjie.myapplication.kotlinTest

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.util.jar.Attributes


open class TestJvmOverload {

    @JvmOverloads fun a(s:String="ni",d:String?="hello",f:String="0",g:String ="world"){

    }
}

class Child constructor(
    context: Context,
    attributes: AttributeSet? = null,
    def:Int = android.R.attr.textViewStyle
):AppCompatTextView(context,attributes,def){


    fun a(a:String){

    }
}