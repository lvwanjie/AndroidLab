package com.lvwanjie.myapplication.kotlinTest.testYuFa

/**
 * 解构函数
 */
import com.lvwanjie.myapplication.androidTest.component.Test

class TestSyntax {

    var s:String = "null"

    public fun a(){
        doSomething()
        s.addWorld()

    }


}

fun main(){
//    play()
    var s = Test.t5()
    var s1 = s.substring(0)
    println("ssss")
}


class Book(var name: String, var price: Float) {
    operator fun component1(): String { // 解构的第一个变量
        return name
    }
    operator fun component2(): Float { // 解构的第二个变量
        return price
    }
}

data class Dog(var name: String, var price: Float){

}

//解构声明
fun play() {
    val book = Book("Kotlin入门", 66.6f);
    val (name,price ) =  book

    println(name)
    println(price)
}


