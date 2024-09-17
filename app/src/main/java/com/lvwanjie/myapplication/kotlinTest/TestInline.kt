package com.lvwanjie.myapplication.kotlinTest

class TestInline {


}

fun main(){
    setL(object :IListener{
        override fun onListener() {

        }
    })

    setC{
        println("abc")
    }

    setF {
        println("f")
        "str"

    }

    setF1 { "str1" }
}

inline fun setF(a:()->String){
    println( a())
}

fun setF1(a:()->String){
    a()
}

fun setL(l:IListener){

}

fun setC(c:MyCallBack){
    c.onCallBack()
}


interface IListener{
    fun onListener()
}

fun interface MyCallBack{
    fun onCallBack();
}