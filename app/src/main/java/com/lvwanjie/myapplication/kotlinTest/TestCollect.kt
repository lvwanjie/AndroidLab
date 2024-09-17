package com.lvwanjie.myapplication.kotlinTest

import com.lvwanjie.myapplication.kotlinTest.testYuFa.doSomething

class TestCollect {

    operator fun plus( s:String){
        doSomething()
    }


    init {

    }

    fun getList(){
        var list = listOf<String>("","")
        list.isNullOrEmpty()
        var mutableList = mutableListOf<String>()
        var a =  arrayListOf<String>()

    }

    public fun getMydata():MyData1 = MyData1



}

public object MyData1{

}

