package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView.testRecyclerAnim

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemAnimator
import androidx.recyclerview.widget.RecyclerView.ItemAnimator.ItemHolderInfo
import com.lvwanjie.myapplication.R

class TestRecyclerViewAnimActivity : AppCompatActivity() {

    public companion object{
        const val TAG = "TestRecyclerViewAnim"
    }
    private val recyclerView:RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val layoutManager:LinearLayoutManager by lazy {
//        ScrollSpeedLinearLayoutManger(this)
        LinearLayoutManager(this)
    }

    private val adapter:MyAdapter by lazy {
        MyAdapter(mutableListOf())
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_recycler_view_anim)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = this.adapter
        var de = DefaultItemAnimator()
        recyclerView.itemAnimator = MyItemAnimator()
    }



    public fun addItem(view: View){
        adapter.addData()
//        layoutManager.smoothScrollToPosition(adapter.itemCount-1)
        recyclerView.smoothScrollToPosition(adapter.itemCount-1)
    }

    public fun removeItem(view: View){
        adapter.removeData()
    }


    class MyItemAnimator : ItemAnimator(){



        override fun animateDisappearance(
            p0: RecyclerView.ViewHolder,
            p1: ItemHolderInfo,
            p2: ItemHolderInfo?
        ): Boolean {
            Log.i(TAG, "animateDisappearance: p1=$p1 p2=$p2")
            return false
        }

        override fun animateAppearance(
            p0: RecyclerView.ViewHolder,
            p1: ItemHolderInfo?,
            p2: ItemHolderInfo
        ): Boolean {
            Log.i(TAG, "animateAppearance: p1=$p1 p2=$p2")
            return false
        }

        override fun animatePersistence(
            p0: RecyclerView.ViewHolder,
            p1: ItemHolderInfo,
            p2: ItemHolderInfo
        ): Boolean {
            Log.i(TAG, "animatePersistence: p1=$p1 p2=$p2")
            return false
        }

        override fun animateChange(
            p0: RecyclerView.ViewHolder,
            p1: RecyclerView.ViewHolder,
            p2: ItemHolderInfo,
            p3: ItemHolderInfo
        ): Boolean {
            Log.i(TAG, "animatePersistence: p1=$p1 p2=$p2")
            return false
        }

        override fun runPendingAnimations() {
            Log.i(TAG, "runPendingAnimations: ")
        }

        override fun endAnimation(p0: RecyclerView.ViewHolder) {
            Log.i(TAG, "endAnimation: $p0")
        }

        override fun endAnimations() {
            Log.i(TAG, "endAnimations: ")
        }

        override fun isRunning(): Boolean {
            Log.i(TAG, "isRunning: ")
            return false;
        }

    }


    class MyAdapter(var list:MutableList<String>) :RecyclerView.Adapter<MyVH>(){


        fun addData(){
            var index =  list.size
            var str = "这是 第 $index 个"
            list.add(str)
            notifyItemInserted(index)

        }

        fun removeData(){
            list.removeAt(0)
            notifyItemRemoved(0)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
            var view = LayoutInflater.from(parent.context).inflate(R.layout.item_anin_rv,parent,false);
            return MyVH(view)
        }

        override fun getItemCount(): Int {
            return list.size;
        }

        override fun onBindViewHolder(holder: MyVH, position: Int) {
            holder.bind(list[position],position)
        }

    }

    class MyVH(var view: View):RecyclerView.ViewHolder(view){

        var tv = itemView.findViewById<TextView>(R.id.tv);

        public fun bind(str:String,pos:Int){
            tv.text = str
            if(pos%2==0){
                itemView.setBackgroundColor(Color.parseColor("#000000"))
                tv.setTextColor(Color.parseColor("#FFFFFF"))
            }else{
                itemView.setBackgroundColor(Color.parseColor("#F00000"))
                tv.setTextColor(Color.parseColor("#000000"))

            }
        }
    }



}

fun ItemHolderInfo.toString():String{
    return "||left:$left;top:$top;right:$right;bottom:$bottom ||"
}