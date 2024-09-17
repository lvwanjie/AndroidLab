package com.lvwanjie.myapplication.kotlinTest.testYuFa

class testReified {


}



fun <T> a(int:Int,clazz: Class<T>){
    var c = clazz
}

inline fun <reified T> b(int:Int){
    var a = T::class.java
}

fun main(){
    a(0,Fa::class.java)
    b<Fa>(0)
}

open class Fa{
    open fun a(){

    }
}



class Ch:Fa(){
    override fun a(){

    }
}