package com.lvwanjie.myapplication.kotlinTest.testYuFa


class Person(var name: String, var age: Int) {

    fun eat() {
        println("吃柠檬")
    }

    fun work(hour: Int): Int {
        println("work $hour hour,earn ￥${hour * 60}")
        return hour * 60
    }
}

fun main() {
    val person: Person = Person("hzh", 23)
    val result = with(person) {
        age = 24
        eat()
        work(8) // 返回480
    }

    println("result is:$result")
}

fun a(any:Any){

}

fun main1() {
    val person: Person? = Person("hzh", 23)
    val result = person?.let {
        it.age = 24
        it.eat()
        it.work(8) // 返回480
    }
    println("result is:$result")
}


