package com.lvwanjie.myapplication.kotlinTest.testYuFa


inline fun printA() {
    println("A")
}

private fun b() {
    printA()
}

private fun c(ac: (Int) -> Int) {
    var r = ac(5);
    println(r)
}

private fun d(a: Int): Int {
    return a + 1;
}

var e: (Int) -> Int = {
    var v = it + 1
    v;
}


private fun f() {
    println(e(0))
    c(e)
    c { d(it) }
    c { d(3) }
}


private inline fun g(a: (String) -> Unit) {
    a("abc")
}

var h: (String) -> Unit = {
    println(it)
}

fun i() {
    g(h)

}


fun main() {
    f()
}