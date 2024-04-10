package com.lvwanjie.myapplication.androidTest.testAnim

import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R

class TestAnimActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestAnimActivity.k"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_anim)
    }

    fun btClick(view: View){
        testAnim()
    }

    private fun testAnim(){
        var objectAnimator = ObjectAnimator.ofFloat(this,"a",0f,100f)
        objectAnimator.interpolator = object:LinearInterpolator(){
            override fun getInterpolation(input: Float): Float {
                Log.i(TAG, "getInterpolation: $input")
                return super.getInterpolation(input)
            }
        }
        objectAnimator.setEvaluator { fraction, startValue, endValue ->
            Log.i(TAG, "setEvaluator: $fraction,$startValue,$endValue")
        }

        objectAnimator.duration = 500
        objectAnimator.start()
    }
    fun a() {
        val o = Any()
    }

    fun setA(f:Float){

    }

    fun getA(f:Float){

    }
}