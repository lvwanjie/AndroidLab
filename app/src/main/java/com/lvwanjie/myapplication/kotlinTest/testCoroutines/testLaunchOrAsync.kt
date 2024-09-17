package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.log

/**
 * launch 返回的job 不包含返回结果，async 可以使用wait 获取返回结果
 * 异常：launch中会立刻抛出异常，async中 会再调用await方法中抛出
 */

fun testLaunchOrAsync(){

    runBlocking {
        println("log 1")
        var job = GlobalScope.launch {
            println("launch")
//            var a:String? = null
//            a!!.split("")
            try {
                delay(2000)

            }catch (e: Exception){
                println("launch catch ${e.message}")
            }
            println("end launch")
        }
        println("log 2")
        job.cancel()
        val deffer = GlobalScope.async{
            println("async")
            delay(2000)
            return@async "abc"
        }
        println("log 3")
        var s = deffer.await();
        println("log 4 $s")


    }

}

fun main(){
    testLaunchOrAsync()
//    testJoin()
}

fun testJoin(){
    runBlocking {
        println("log_1")
        var job1 = GlobalScope.launch {
            println("launch_1")
            delay(2000)
        }
        job1.join()
        println("log_2")
        var job2 = GlobalScope.launch {
            println("launch_2")
            delay(2000)
        }
        job2.join()
        println("log_3")
        var job3 = GlobalScope.launch {
            println("launch_3")
            delay(2000)
        }
        job3.join()
    }
}