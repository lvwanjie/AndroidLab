package com.lvwanjie.myapplication.kotlinTest.testDelegated

class TestByLazy {
    lateinit var d:String

    val a:String by lazy {
        b()
    }

    val c:String by lazy {
        var a = "ab"
        var c  = a+"1"
        return@lazy c
    }

    fun b():String{
        println("p")
        return "abc"
    }


}