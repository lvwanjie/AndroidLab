package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TestCoroutines2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coroutines2)
    }

    companion object{
        const val TAG = "Coroutines:"
    }

    fun btClick(view: View){
//        setUpUI()
        setUpUI2()
    }

    private fun setUpUI(){
        GlobalScope.launch(Main) {
            val dataDeferred  = requestDataAsync()
            doSomethingElse()
            val data = dataDeferred.await()
            processData(data)
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()
        Handler(Looper.getMainLooper()).postDelayed({
            doSomethingElse_post()
        },500)
    }

    private fun setUpUI2(){
        GlobalScope.launch(Dispatchers.Main) {
            doSomethingElse()
            var data = "default data"
            withContext(Dispatchers.IO){
                data = getData()
            }
            processData(data)
            doSomethingElse3()
        }
        Thread.sleep(1000)
        doSomethingElse2()
    }

   fun  getData():String{
        println("start get Data")
        Thread.sleep(1000)
        println("end get Data")
        return "get data form coroutines"
    }

    private fun requestDataAsync(): Deferred<String> {
        // 启动一个异步协程去执行耗时任务
        return GlobalScope.async {
            requestData()
        }
    }


    private fun requestData():String{
        println("${TAG}requestData: ${Thread.currentThread().name}" )
        Thread.sleep(2000)
        return "data"
    }

    private fun doSomethingElse(){
        println("${TAG}doSomethingElse")
    }

    private fun processData(data:Any){
        println("$TAG processData $data")
    }

    private fun doSomethingElse2(){
        println("${TAG}doSomethingElse2")
    }

    private fun doSomethingElse3(){
        println("${TAG}doSomethingElse3")
    }

    private fun doSomethingElse_post(){
        println("${TAG}doSomethingElse_post")
    }
}