package com.hengchang.testoptimize

import android.content.Intent
import android.os.Bundle
import android.os.Debug
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.hengchang.testoptimize.testBlockCanary.TestBlockActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        a()
    }


    fun startProfilePage(view :View){
        startActivity(Intent(this,TestProfileActivity::class.java))
    }

    fun startBlockCanaryPage(view :View){
        startActivity(Intent(this,TestBlockActivity::class.java))
    }



    fun btClick(view: View){
        d()

    }

    fun d(){
        println("abc")
        a()
    }


     fun a(){
        Debug.startMethodTracing("lwj_trace_a")
         var list = mutableListOf<Int>()
        var i = 0;
        while (i<1000){
            i++
            list.add(i)
        }
        b(list)
        Debug.stopMethodTracing()
    }

    fun b(list:List<Int>){
        for(j in list.indices){
            println(list[j])
            e()
            f()
        }
    }

    fun e(){
        Log.i("TAG", "e: ")
    }

    fun f(){
        Log.i("TAG", "e: ")
    }
}