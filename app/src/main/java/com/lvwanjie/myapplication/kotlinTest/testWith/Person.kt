package com.lvwanjie.myapplication.kotlinTest.testWith

class Person(var name:String,var age:Int) {
    fun eat(){
        println("吃")
    }

    fun work(hour:Int):Int{
        println("work $hour, earn ￥${hour*60}")
        return hour * 60
    }
}

fun main(){
    val person:Person = Person("lwj",23)
    val result = with(person){
        age = 24
        eat()
        work(8)
        return@with
    }
   println("$result")

}