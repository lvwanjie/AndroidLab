package com.lvwanjie.myapplication.kotlinTest

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * launch 返回的job 不包含返回结果，async 可以使用wait 获取返回结果
 * 异常：launch中会立刻抛出异常，async中 会再调用await方法中抛出
 */

fun testTryCatch(){
    runBlocking<Unit> {
        val job = GlobalScope.launch {
            try {
                throw Exception()
            } catch (e: Exception) {
                println("catch in coroutine")
            }
        }
        job.join()
        val deferred = GlobalScope.async {
            println("async")
            throw Exception()
        }
        try {
            deferred.await()
        } catch (e: Exception) {
            println("catch in await")
        }
    }
}

fun main(){
//    testTryCatch()
//    testTryCatch1()
//    testTryCatch2()
//    testTryCatch3()
    testTryCatch4()
}

fun testTryCatch1(){
    runBlocking {
        launch {
            println("start A")
            delay(100)
            println("A throw exception")
            throw NullPointerException()
        }

        launch {
            println("start B")
            delay(200)
            println("end B")
        }
        delay(100)
        println("father end")
    }
}

fun testTryCatch2(){
    var scope = CoroutineScope(Job())
    runBlocking {
        var job1 = scope.launch {
            println("start A")
            delay(100)
            println("A throw exception")
        throw NullPointerException()
        }
        var job2 = scope.launch {
            println("start B")
            delay(200)
            println("end B")
        }

        GlobalScope.launch {
            println("start global")
            delay(200)
            println("end global")
        }
        delay(1000)
    }

}


/**
 * 参考文档https://juejin.cn/post/7130132604568731655
 * 添加CoroutineExceptionHandler
 * 这里子协成a抛出异常，会影响字协成b，b协成没有执行完 （"end b"没有打印）
 */
fun testTryCatch3(){
    //在这里设置CoroutineExceptionHandler 可以捕获作用域内所有的异常
    var scope = CoroutineScope(Job()+CoroutineExceptionHandler { _, t->println("========CoroutineExceptionHandler inner: $t") })
    runBlocking() {
        //在这里只能捕获当前job1 里的异常，job2里抛异常捕获不到
        var job1 = scope.launch(CoroutineExceptionHandler { _, t->println("========CoroutineExceptionHandler inner: $t.") }) {
            println("start A")
            delay(100)
            println("A throw exception")
            throw NullPointerException()
        }
        var job2 = scope.launch {
            println("start B")
            delay(200)
//            throw NullPointerException()
            println("end B")
        }

        delay(1000)
    }

}

/**
 * 测试SupervisorJob
 *  这里子协成a抛出异常，不会影响字协成b，b协成执行完 （"end b"会打印）
 *
 */
fun testTryCatch4(){

    var scope = CoroutineScope(SupervisorJob() +CoroutineExceptionHandler { _, t->println("========CoroutineExceptionHandler inner: $t") })
    runBlocking() {
        var job1 = scope.launch(CoroutineExceptionHandler { _, t->println("========CoroutineExceptionHandler inner: $t.") }) {
            println("start A")
            delay(100)
            println("A throw exception")
            throw NullPointerException()
        }
        var job2 = scope.launch {
            println("start B")
            delay(200)
            println("end B")
        }

        delay(1000)
    }

}
