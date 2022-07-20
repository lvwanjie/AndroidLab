package com.lvwanjie.myapplication.androidTest.widget.testRecyclerView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lvwanjie.myapplication.R
import java.util.*

class RcAdapter(var context: Context) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){


    private  var list :ArrayList<ItemData> = ArrayList()
    init {
        initFakeData()
    }

    private fun initFakeData(){
        for (i in 0..20){
            var itemData = ItemData()
            itemData.name = "这是第$i 个"
            if(i == 5){
                itemData.itemType = ItemData.ITEM_TYPE2
            }
            list.add(itemData)
        }
    }

    fun changFirstItem(){
        var newList= ArrayList<ItemData>()
        var itemData = ItemData()
        itemData.name = list[0].name + Random().nextInt(10)
        newList.add(itemData)
        for(i in 1..list.size-1){
            newList.add(list[i])
        }
        list = newList
        notifyDataSetChanged()
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

class RcViewHolder1(itemView: View):RecyclerView.ViewHolder(itemView){

    private var textview = itemView.findViewById<TextView>(R.id.text_view)

    fun bind(itemData: ItemData){
        textview.text = itemData.name
    }
}

class RcViewHolder2(itemView: View):RecyclerView.ViewHolder(itemView){
    fun bind(itemData: ItemData){

    }
}