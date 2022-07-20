package com.lvwanjie.myapplication.kotlinTest

class TestLateInit {

     lateinit var a:String

     val b:String by lazy { "s" }


    public fun t(){
        a = ""
        a = "1"
    }

    public fun User.f2(){
        f1()
    }
}