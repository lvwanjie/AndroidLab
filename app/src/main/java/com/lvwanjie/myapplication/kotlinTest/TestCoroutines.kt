package com.lvwanjie.myapplication.kotlinTest

import android.os.AsyncTask
import kotlinx.coroutines.*

class TestCoroutines {


    public fun t1(){
        GlobalScope.launch {
            a()
        }

        runBlocking {

        }

//        var coroutineScope = CoroutineScope()



    }

    suspend fun a(){
        Thread.sleep(10000);
        withContext(Dispatchers.IO){

        }

    }


    public fun testAsyncTask(){

       var a =  object :AsyncTask<String,String,String>(){
           override fun doInBackground(vararg params: String?): String {
               TODO("Not yet implemented")
           }

       }
    }


}