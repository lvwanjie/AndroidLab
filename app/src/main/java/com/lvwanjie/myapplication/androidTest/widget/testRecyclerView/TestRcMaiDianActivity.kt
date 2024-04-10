package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnAttachStateChangeListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
import com.lvwanjie.myapplication.R

class TestRcMaiDianActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RcMaiDianAdapter
    private lateinit var layoutManager: LinearLayoutManager;
    companion object{
        const val TAG = "TestRcMaiDianActivity.k"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_rc_mai_dian)
        recyclerView = findViewById(R.id.recycler_view)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        adapter = RcMaiDianAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.addOnChildAttachStateChangeListener(object :OnChildAttachStateChangeListener{

            override fun onChildViewAttachedToWindow(view: View) {
                var pos = layoutManager.getPosition(view)

                Log.i(TAG, "onChildViewAttachedToWindow: p = $pos" )            }

            override fun onChildViewDetachedFromWindow(view: View) {
                var pos = layoutManager.getPosition(view)
                Log.i(TAG, "onChildViewDetachedFromWindow: p = $pos")            }

        })

        ItemShowDetector(recyclerView) { it ->
            Log.i(TAG, "onShow: $it")
        }.apply {
            //设置曝光阈值50%
            visiblePercent = 50
            //设置忽略快速滚动
            ignoreFlipping = true
            //设置需要重新曝光
            needReshow = true
        }
    }
}