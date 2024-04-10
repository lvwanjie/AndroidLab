package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import android.os.Handler
import android.os.Looper
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class testCoroutinesOrigin {

    companion object{
        const val TAG = "testCoroutinesOrigin"
    }

    private fun setUpUI0(){
        GlobalScope.launch(Dispatchers.Main) {
            doSomethingElse()
            processData("data")
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()
    }

    private fun setUpUI(){
        GlobalScope.launch(Dispatchers.Main) {
            val dataDeferred  = requestDataAsync()
            doSomethingElse()
            val data = dataDeferred.await()
            processData(data)
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()

    }


    private fun setUpUI2(){
        GlobalScope.launch(Dispatchers.Main) {
            doSomethingElse()
            var data:Any;
            withContext(Dispatchers.IO){
                data = getData()
            }
            processData(data)
            var data2:Any;

            data2 = getDataDelay()
            processData(data2)
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()
    }

    private fun setUpUI3(){
        GlobalScope.launch(Dispatchers.Main) {
            doSomethingElse()
            var data = "default data"
            data = getDataDelay()

            processData(data)
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()
    }


     suspend fun  getData():String{
        println("get Data")
         return "get data from coroutines"
     }

    suspend fun  getData2():String{
        println("get Data")
        return "get data from coroutines"
    }

    suspend fun  getDataDelay():String{

        delay(1000)

        return "get data from coroutines"
    }

    private fun requestDataAsync(): Deferred<String> {
        // 启动一个异步协程去执行耗时任务
        return GlobalScope.async {
            requestData()
        }
    }


    private fun requestData():String{
        println("${TestCoroutines2Activity.TAG}requestData: ${Thread.currentThread().name}" )
        Thread.sleep(2000)
        return "data"
    }

    private fun doSomethingElse(){
        println("${TAG}doSomethingElse")
    }

    private fun processData(data:Any){
        println("${TAG} processData $data")
    }

    private fun doSomethingElse2(){
        println("${TAG}doSomethingElse2")
    }

    private fun doSomethingElse3(){
        println("${TAG}doSomethingElse3")
    }

}