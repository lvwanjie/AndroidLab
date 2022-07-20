package com.lvwanjie.myapplication.androidTest.widget.testListView

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import com.lvwanjie.myapplication.R
import java.util.*

class TestListViewActivity : AppCompatActivity() {

    private lateinit var listView:ListView
    private lateinit var adapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_list_view)
        listView = findViewById(R.id.list_view)
        adapter = MyAdapter(this)
        listView.adapter = adapter

    }


    fun btClick(view:View){
        adapter.resetData(getData())
    }

    private fun getData():ArrayList<ItemData> {
        var list = ArrayList<ItemData>()
        var randomInt = Random().nextInt(10)
        for (i in 0..20) {
            var itemData = ItemData("这是第$i 个 + chang $randomInt")
            list.add(itemData)
        }
        return list
    }
}

class MyAdapter(var context: Context) :BaseAdapter(){


    private var list = ArrayList<ItemData>()
    init {
        for (i in 0..20){
            var itemData = ItemData("这是第$i 个")
            list.add(itemData)
        }
    }


    fun resetData(list:ArrayList<ItemData>){
        this.list = list
        notifyDataSetChanged()
    }


    override fun getCount(): Int {
       return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view :View
        view = if(convertView == null){
            LayoutInflater.from(context).inflate(R.layout.widget_test_list_view_item,parent,false)
        }else{
            convertView
        }

        var textView = view.findViewById<TextView>(R.id.text_view)
        textView.text = list[position].text
        return view;
    }

}

class ItemData(var text:String){

}