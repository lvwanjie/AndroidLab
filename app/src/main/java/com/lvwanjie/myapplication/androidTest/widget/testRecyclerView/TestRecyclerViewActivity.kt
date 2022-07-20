package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListAdapter
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lvwanjie.myapplication.R
import java.util.*

class TestRecyclerViewActivity : AppCompatActivity() {

    private lateinit var recyclerView:RecyclerView
    private lateinit var adapter: RcAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recycler_view)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = RcAdapter(this)
        recyclerView.adapter = adapter
    }

    fun btClick(view: View){
       adapter.changFirstItem()


    }

    fun btClick2(view: View){
        Timer().schedule(object :TimerTask(){
            override fun run() {
                runOnUiThread{
                    adapter.changFirstItem()
                }
            }

        },1000,1000)
    }
}