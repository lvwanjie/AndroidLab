package com.lvwanjie.myapplication.kotlinTest

import android.app.Activity
import java.util.logging.Handler

data class MyData(
    val i:Int,
    var s:String
)

class Normal(val s:String){
    init {
       var myData = MyData(0,"")
//        myData.

        fun main() {
            try {
                val o = Any()
                val field = Handler::class.java.getDeclaredField("")
                field.isAccessible = true
                field[o]
                field[o] = Any()
            } catch (e: NoSuchFieldException) {
                throw RuntimeException(e)
            } catch (e: IllegalAccessException) {
                throw RuntimeException(e)
            }


        }

    }

    fun b(){
        my{}
    }

    fun my(a:()->Any){
        my{
            a
        }
    }


}

class A(

) : (Activity) -> Unit {
    override fun invoke(p1: Activity) {
        TODO("Not yet implemented")
    }
}