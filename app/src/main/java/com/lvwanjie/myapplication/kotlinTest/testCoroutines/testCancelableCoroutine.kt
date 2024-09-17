package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import android.provider.Settings.Global
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.suspendCancellableCoroutine
import java.util.concurrent.LinkedBlockingDeque
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


fun main(){
    var tasks = MyTask<String>()
    var job = GlobalScope.launch(Dispatchers.IO){
        var str = tasks.execute()

    }

    job.cancel()
    MainScope()

}


class MyTask<T>{

    var m = M<T>()


    suspend fun  execute(): T {
        return suspendCancellableCoroutine { continuation ->
//        continuation.invokeOnCancellation {
//            cancel()  //当协程代表块被取消时，会收到回调，从而取消okhttp请求
//        }

            var c = object :MyCoroutineCallBack<T>{
                override fun onResponse(res: MyResponse<T>) {
                    continuation.resume(res.body())

                }

                override fun onError(erorStr: String) {
                    continuation.resumeWithException(NullPointerException("error"))
                }
            }
            m.myQueue(c)
        }
    }

}




class M<T>{

    init {
        GlobalScope.launch(Dispatchers.Default){
            while (true){
                println("start take")
                var c = list.take()
                var m  =MyResponse<T>("" as T)
                c.onResponse(m)
                println("end take")
            }
        }
    }

    var list= LinkedBlockingDeque<MyCoroutineCallBack<T>>()

    fun myQueue(c:MyCoroutineCallBack<T>){
        list.add(c)
    }


}


//class M<T>{
//    var list= mutableListOf<MyCoroutineCallBack<T>>()
//
//    fun myQueue(c:MyCoroutineCallBack<T>){
//        list.add(c)
//    }
//
//
//    suspend fun  myAwait(): T {
//        return suspendCancellableCoroutine { continuation ->
//            continuation.invokeOnCancellation {
////            cancel()  //当协程代表块被取消时，会收到回调，从而取消okhttp请求
//            }
//
//            var c = object :MyCoroutineCallBack<T>{
//                override fun onResponse(res: MyResponse<T>) {
//                    continuation.resume(res.body())
//
//                }
//
//                override fun onError(erorStr: String) {
//                    continuation.resumeWithException(NullPointerException("error"))
//                }
//            }
//            myQueue(c)
//        }
//    }
//}



interface MyCoroutineCallBack<T>{
    fun onResponse(response:MyResponse<T>)

    fun onError(errorStr:String)
}

class MyResponse<T>(var t:T){
    var code:Int =0
    fun body():T{
        var s = ""
        return t!!
    }
}
