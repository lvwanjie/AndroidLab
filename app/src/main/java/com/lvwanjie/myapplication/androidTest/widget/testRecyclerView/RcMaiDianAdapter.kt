package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lvwanjie.myapplication.R
import java.util.ArrayList

class RcMaiDianAdapter (var context: Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private  var list : ArrayList<ItemData> = ArrayList()
    companion object{
        const val TAG = "RcMaiDianAdapter.k"
    }

    init {
        initFakeData()
    }

    private fun initFakeData(){
        for (i in 0..20){
            var itemData = ItemData()
            itemData.name = "这是第$i 个"
//            if(i == 5){
//                itemData.itemType = ItemData.ITEM_TYPE2
//            }
            list.add(itemData)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == ItemData.ITEM_TYPE1) {
            var view = LayoutInflater.from(context).inflate(R.layout.widget_test_rc_item_view, parent, false)
            RcViewHolder1(view);
        } else {
            var view = LayoutInflater.from(context).inflate(R.layout.widget_test_rc_item_view_2, parent, false)
            RcViewHolder2(view);
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.i(TAG, "onBindViewHolder: $position")
        if(holder is RcViewHolder1){
            holder.bind(list[position])
        }else if(holder is RcViewHolder2){
            holder.bind(list[position])
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {

        return list[position].itemType

    }
}

