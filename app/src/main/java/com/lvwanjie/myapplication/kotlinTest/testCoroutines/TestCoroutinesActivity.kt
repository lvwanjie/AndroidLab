package com.lvwanjie.myapplication.kotlinTest.testCoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.*
import okhttp3.Dispatcher

/**
 * 协成的几种实现方式
 */
class TestCoroutinesActivity : AppCompatActivity() {

    companion object{
       const val TAG = "CoroutinesActivity.kt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_coroutines)
    }

     fun btRunBlocking(view: View){

         runBlocking {

         }

    }

    fun btGlobalScope(view: View){
        GlobalScope.launch {

        }
    }

    var coroutineScope = CoroutineScope(Dispatchers.Main)
    fun btCoroutineScope(view: View){
        coroutineScope.launch(Dispatchers.Main) {
            var s  = ""
            var l = withContext(Dispatchers.IO){
                Thread.sleep(3000)
                return@withContext "withContext"
            }
            Toast.makeText(this@TestCoroutinesActivity,l,Toast.LENGTH_SHORT).show()

        }
    }

    fun btMainScope(view: View){

    }

    fun btViewModelScope(view: View){

    }

    fun btLifecycleScope(view: View){
        lifecycleScope.launch{

        }

    }

    override fun onDestroy() {
        super.onDestroy()
        coroutineScope.cancel()

    }
}