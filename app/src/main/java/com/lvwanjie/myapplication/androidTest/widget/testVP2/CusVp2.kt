package com.lvwanjie.myapplication.androidTest.widget.testVP2

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import kotlin.math.log

class CusVp2 @JvmOverloads constructor(
    context: Context,
    attributes: AttributeSet?= null,
    def:Int = 0
): FrameLayout(context,attributes,def){

    companion object{
        const val TAG = "CusVp2"
    }

    var vp2:ViewPager2? = null;

    @RequiresApi(Build.VERSION_CODES.M)
    public fun bindVp2(vp2:ViewPager2){
        this.vp2 = vp2



    }


    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {

//        if(ev?.action == MotionEvent.ACTION_DOWN){
//            Log.i(TAG, "dispatchTouchEvent: ")
//        }else if(ev?.action == MotionEvent.ACTION_UP){
//            val clickPos = getClickItem(ev)
//            if(clickPos > 0){
//                vp2?.setCurrentItem(clickPos)
//            }
//        }
        return super.dispatchTouchEvent(ev)
    }


    private fun getClickItem(ev: MotionEvent?):Int{
        val recyclerView = vp2?.getChildAt(0) as RecyclerView
        val itemCount  = vp2?.adapter?.itemCount?:0
        val curItem = vp2?.currentItem?:0
        val curItemView = recyclerView.findViewHolderForLayoutPosition(curItem)?.itemView
        logPos(curItemView,"curItem")
        var itemPos = -1
        var leftItemView:View? = null
        var rightItemView:View? = null
        if(curItem >0){
            leftItemView = recyclerView.findViewHolderForLayoutPosition(curItem -1)?.itemView
            logPos(leftItemView,"leftItem")
        }
        if(curItem <itemCount -1 ){
            rightItemView = recyclerView.findViewHolderForLayoutPosition(curItem +1)?.itemView
            logPos(rightItemView,"rightItem")
        }
        if(checkViewInnerClick(curItemView,ev)){
            itemPos = -1;
        }else if(checkViewInnerClick(leftItemView,ev)){
            itemPos = curItem -1
        }else if(checkViewInnerClick(rightItemView,ev)){
            itemPos = curItem +1
        }
        return itemPos
    }

    private fun checkViewInnerClick(view: View?,ev: MotionEvent?):Boolean{
        if(view == null || ev == null){
            return false
        }

        if(ev.x > view.left &&
            ev.x < view.right &&
            ev.y > view.top &&
            ev.y < view.bottom){
            return true
        }

        return false
    }


    private fun getVp2Pos(){
        var recyclerView = vp2?.getChildAt(0) as RecyclerView
        var itemCount  = vp2?.adapter?.itemCount?:0
        var curItem = vp2?.currentItem?:0
        
        var view = recyclerView.findViewHolderForLayoutPosition(curItem)?.itemView
        logPos(view,"curItem")

        if(curItem >0){
            var view = recyclerView.findViewHolderForLayoutPosition(curItem -1)?.itemView
            logPos(view,"leftItem")
        }

        if(curItem <itemCount -1 ){
            var view = recyclerView.findViewHolderForLayoutPosition(curItem +1)?.itemView
            logPos(view,"rightItem")
        }

    }


    private fun logPos(view:View?,tagStr:String = ""){
        if(view == null){
            Log.i(TAG, "logPos: $tagStr view is null")
            return
        }
        Log.i(TAG, "logPos: $view \n")
        Log.i(TAG, "getVp2Pos scale:${view.scaleY} $tagStr: ${view.left},${view.top},${view.right},${view.bottom}")
    }

}