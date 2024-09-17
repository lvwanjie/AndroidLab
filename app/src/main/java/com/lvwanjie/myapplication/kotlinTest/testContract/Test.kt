package com.lvwanjie.myapplication.kotlinTest.testContract

class Test {
}


fun main(){
    var p = P("a",100)
    println(p.age)
}

class P(val name: String) {//1 类名后面定义的主构造函数，数量<=1

    init {//2 init代码块
        println("init")
    }

     var age: Int? = null

    constructor(name: String, age: Int) : this(name) {//3 次构造函数，数量>=0
        println("second constructor")
        this.age = age
    }
}
