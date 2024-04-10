package com.lvwanjie.myapplication.kotlinTest.testDelegated

import kotlin.reflect.KProperty

class Example {
    // 被委托属性
    var prop: String by Delegate() // 基础对象
}

// 基础类
class Delegate {
    private var _realValue: String = "彭"

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue")
        return _realValue
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue")
        _realValue = value
    }
}

fun main(args: Array<String>) {
    val e = Example()
    println(e.prop)    // 最终调用 Delegate#getValue()
    e.prop = "Peng"    // 最终调用 Delegate#setValue()
    println(e.prop)    // 最终调用 Delegate#getValue()
}

//输出：
//getValue
//彭
//setValue
//getValue
//Peng
