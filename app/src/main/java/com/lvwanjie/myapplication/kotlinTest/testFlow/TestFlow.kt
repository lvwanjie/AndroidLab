package com.lvwanjie.myapplication.kotlinTest.testFlow

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis


fun main(){
//    test()
//    testHotFlow()
//    testCodeFLow()

//    testSharedFlow()
    testStateFlow()
}

//背压
fun test(){
    runBlocking {
        val time = measureTimeMillis {
            flow {
                (1..5).forEach {
                    delay(200)
                    println("emit: $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
                    emit(it)
                }
            }.buffer().collect {
                // 消费效率较低
                delay(500)
//                Thread.sleep(1000)
                println("Collect $it, ${System.currentTimeMillis()}, ${Thread.currentThread().name}")
            }
        }
        println("time: $time")
    }

}

fun testHotFlow(){
    runBlocking {
        val hotFlow = MutableSharedFlow<Int>()

        launch {
            repeat(5) {
                delay(1000)
                hotFlow.emit(it)
            }
        }

        // 观察者1
        hotFlow.collect {
            println("Observer 1: $it")
        }

        // 观察者2
        delay(3000) // 观察者2延迟3秒后订阅
        hotFlow.collect {
            println("Observer 2: $it")
        }

//        delay(5000) // 为了保持主线程运行
    }
}

fun testSharedFlow() {

    val sharedFlow = MutableSharedFlow<Int>(
        replay = 0,//相当于粘性数据
        extraBufferCapacity = 0,//接受的慢时候，发送的入栈
        onBufferOverflow = BufferOverflow.SUSPEND
    )
    runBlocking{
        launch {

            sharedFlow.collect {
                println("collect1 received ago shared flow $it")

            }
        }
        launch {
            (1..5).forEach {
//                println("emit1  send ago  flow $it")
                sharedFlow.emit(it)
                println("emit1 send after flow $it")
            }
        }
        // wait a 100
        delay(100)
        launch {
            sharedFlow.collect {
                println("collect2 received shared flow $it")
            }
        }
    }

}

private fun testStateFlow() {
    val stateFlow = MutableStateFlow<Int>(value = -1)

    runBlocking{
        launch {

            stateFlow.collect {
                println("collect1 received ago shared flow $it")
            }
        }
        launch {
            (1..5).forEach {
                println("emit1  send ago  flow $it")
                stateFlow.emit(it)
                delay(100)
                println("emit1 send after flow $it")
            }
        }
        // wait a minute
        delay(100)
        launch {
            stateFlow.collect {
                println("collect2 received shared flow $it")
            }
        }
    }

}


fun testCodeFLow(){
    runBlocking {
        val coldFlow = flow {
            emit("Line 1")
            delay(1000)
            emit("Line 2")
            delay(1000)
            emit("Line 3")
            delay(1000)
            emit("Line 4")
        }

        // 观察者1
        coldFlow.collect {
            println("Observer 1: $it")
        }

        // 观察者2
        delay(1000) // 观察者2延迟2秒后订阅
        coldFlow.collect {
            println("Observer 2: $it")
        }

        delay(5000) // 为了保持主线程运行
    }
}