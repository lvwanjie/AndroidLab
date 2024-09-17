package com.lvwanjie.myapplication.kotlinTest.testYuFa

fun doSomething(){
    println("")
}

fun String.addWorld() = this + "world"


fun TestSyntax.b(){
    this.a()

}

class A{
    companion object{

    }
}

@JvmOverloads
fun o(a:Int = 8,b:String,c:Double=0.0,d:Int){
    println(a)
}