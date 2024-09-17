package com.lvwanjie.myapplication.androidTest.jetpack.testFlow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class TestFlowActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flow)
    }

    fun btClick1(view: View){
        testCoroutine()
    }

    fun btClick2(view: View){
        testAsync()
    }

    fun btClick3(view:View){
        testMultiple()
    }

    fun btClick4(view: View){
        testRunBlocking()
    }

    /**
     * 执行结果
     * IogetData : DefaultDispatcher-worker-3
     * MaingetData : main
     * 使用withContext ，后面的代码会等待
     */
    private fun testCoroutine(){
        lifecycleScope.launch(Dispatchers.Main){
            var str = ""
            withContext(Dispatchers.IO){
                str = getData()
                println("Io$str : ${Thread.currentThread().name}")
            }
            println("Main$str : ${Thread.currentThread().name}")
        }

    }

    /**
     * 执行结果：
     * DeferredCoroutine{Active}@4bf734b thread = main
     * async getData
     * getData
     * 所以使用async, 后续代码都不会执行
     */
    private fun testAsync(){
        lifecycleScope.launch(Dispatchers.Main){
            var deferred = async(Dispatchers.IO){
                println("async getData")
                return@async getData()
            }
            println("$deferred thread = ${Thread.currentThread().name}")
            var str = deferred.await();
            println(str)

        }
    }

    /**
     * 这种是串行，上面使用async 是并行
     */
    private fun testMultiple(){
        var deferred = lifecycleScope.launch (Dispatchers.IO) {

            getData()
            getData2()
        }
    }

    /**
     * 执行顺序
     * runBlocking getData t = main
     * testRunBlocking  t = main
     * 会阻塞代码块后续代码，launch 不会，launch 会先执行外边的 再执行挂起函数的
     */
    private fun testRunBlocking(){
//        var str:String ;
        runBlocking {
            var str = getData()
            println("runBlocking $str t = ${Thread.currentThread().name}")
        }
        println("testRunBlocking  t = ${Thread.currentThread().name}")

//        lifecycleScope.launch {
//            str = getData();
//        }
//
//        println(str)
    }

    /**
     * 几种场景
     * https://blog.csdn.net/u013700502/article/details/129543737
     */
    fun testFlow(){

    }

    suspend fun getData():String{
         delay(1000)
         return "getData"
    }

    suspend fun getData2():String{
        delay(1000)
        return "getData2"
    }


}