package com.lvwanjie.myapplication.kotlinTest.testWith

import android.view.View

class Person(var name:String,var age:Int) {
    fun eat(){
        println("吃")
    }

    fun work(hour:Int):Int{
        println("work $hour, earn ￥${hour*60}")
        return hour * 60
    }

    fun doSomething(){
        println("doSomething")
        callBack?.onCallBack()
    }

    private var callBack: MyCallBack? = null

    fun setCallBack(callBack: MyCallBack){
        this.callBack = callBack
    }

}


 interface MyCallBack{
    fun onCallBack()
}



fun main(){
    val person:Person = Person("lwj",23).also {
        println("person also")
    }

    person.setCallBack(object :MyCallBack{
        override fun onCallBack() {
            println("onCallBack")
        }
    }.also {

        println("callback also")
    }).also {
        println("set Callback also")
    }

    person.doSomething()
    person.work(10).also { println(it) }
    person.doSomething()
    person.doSomething()
    val result = with(person){
        age = 24
        eat()
        work(8)
        return@with
    }
   println("$result")

}

fun testW(){
    var p = with(Person("a",0)){
        name = "b"
    }

    var p1 = Person("a",0)?.let {  }

    var p2:Person? = Person("0",0)
    p2.run {

    }

    var p3:Person? = Person("0",0)

    p3.apply {

    }

    var p4:Person? = Person("0",0)
    p4.let {

    }

}