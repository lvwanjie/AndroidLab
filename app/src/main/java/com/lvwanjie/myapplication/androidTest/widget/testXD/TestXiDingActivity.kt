package com.lvwanjie.myapplication.androidTest.widget.testXD

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginStart
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.androidTest.widget.testRecyclerView.RcAdapter
//import net.lucode.hackware.magicindicator.MagicIndicator

class TestXiDingActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestXiDingActivity.kt"
    }

    private val recyclerView:RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val btExpand:Button by lazy {
        findViewById(R.id.bt_expand)
    }
    private val btScrollTo:Button by lazy {
        findViewById(R.id.bt_scroll_item)
    }

    private val coordinatorLayout:CoordinatorLayout by lazy {
        findViewById(R.id.coordinatorLayout)
    }

    private val appBarLayout:AppBarLayout by lazy {
        findViewById(R.id.app_bar)
    }
    private val tab:LinearLayout by lazy {
        findViewById(R.id.tab_indicator)
    }
    var linearLayoutManager = LinearLayoutManager(this)
    private var isExpand = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_xi_ding_activity)
//        setContentView(R.layout.activity_test_recycler_view)
        recyclerView.layoutManager = linearLayoutManager
        var rcAdapter = RcAdapter(this)
        recyclerView.adapter = rcAdapter

        btExpand.setOnClickListener{
            if(isExpand){
                rcAdapter.remove(0,6)
                rcAdapter.notifyItemRangeRemoved(0,6)
                tab.visibility = View.GONE
            }else {
                rcAdapter.addAll()
                rcAdapter.notifyItemRangeInserted(0,6)
                linearLayoutManager.scrollToPositionWithOffset(0,0)
                tab.visibility = View.VISIBLE
            }
            isExpand = !isExpand

        }
        btScrollTo.setOnClickListener{
            appBarLayout.setExpanded(false)
//            recyclerView.scrollToPosition(5)
//            recyclerView.smoothScrollBy(0,300)
            linearLayoutManager.scrollToPositionWithOffset(8,0)
//
//            for(i in 0..5){
//                var y = recyclerView.findViewHolderForLayoutPosition(i)?.itemView?.y
//                Log.i(TAG, "view_y: $y")
//            }
        }
    }


    private fun scrollPosition(){

    }

//    public fun btClick(view: View){
////        linearLayoutManager.scrollToPosition(18)
////        recyclerView.smoothScrollBy(0,100)
//
//    }
}