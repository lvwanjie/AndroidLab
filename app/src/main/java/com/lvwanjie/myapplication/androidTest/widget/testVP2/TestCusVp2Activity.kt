package com.lvwanjie.myapplication.androidTest.widget.testVP2

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.FrameLayout
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.androidTest.widget.testVP2.TestVp2Activity.Companion.TAG

class TestCusVp2Activity : AppCompatActivity() {

    private val cusVp2:CusVp2 by lazy {
        findViewById(R.id.cusVp2)
    }

    private val flController:FrameLayout by lazy {
        findViewById(R.id.fl_controller)
    }
    private val view_left:View by lazy {
        findViewById(R.id.left_view)
    }

    private val view_right:View by lazy {
        findViewById(R.id.right_view)
    }

    private val vp2:ViewPager2 by lazy {
        findViewById(R.id.view_page2)
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_cus_vp2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        vp2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        var recyclerview = vp2.getChildAt(0) as RecyclerView
        recyclerview.overScrollMode = View.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(60))
        compositePageTransformer.addTransformer { view, position ->
            val r = 1 - Math.abs(position)
            var s = 0.90f + r * 0.1f;
//            Log.i(TAG, "$view \ncompositePageTransformer: $position  ;;scale$s")
            view.scaleY = s
        }
//        cusVp2.setOnTouchListener(object :OnTouchListener{
//            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
//                Log.i(TAG, "onTouch: "+event?.x)
//               return vp2.dispatchTouchEvent(event)
//            }
//
//        })

        flController.setOnTouchListener(object :OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.i(TAG, "onTouch: "+event?.x)
               return vp2.dispatchTouchEvent(event)
            }
        })

        view_left.setOnTouchListener(object :OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.i(TAG, "onTouch: "+event?.x)
                return vp2.dispatchTouchEvent(event)
            }
        })

        view_right.setOnTouchListener(object :OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                Log.i(TAG, "onTouch: "+event?.x)
                return vp2.dispatchTouchEvent(event)
            }
        })

        view_left.setOnClickListener{
            var curitem = vp2.currentItem
            if(curitem > 0){
                vp2.setCurrentItem(curitem -1,true)
//               viewPage2.currentItem = curitem -1;
            }
        }
        view_right.setOnClickListener{
            var curitem = vp2.currentItem
            if(curitem < (vp2.adapter?.itemCount?:0) -1){
                vp2.currentItem = curitem +1
            }
        }


        vp2.setPageTransformer(compositePageTransformer)
        vp2.offscreenPageLimit = 3
        vp2.adapter = MyAdapter()

        cusVp2.bindVp2(vp2)
    }
}