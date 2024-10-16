package com.x2.business.notice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.lvwanjie.myapplication.R


class GalleryPageAdapter(var list: List<String>) :PagerAdapter(){

    override fun getCount(): Int {
        return list.size
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view === obj
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var view = LayoutInflater.from(container.context).inflate(R.layout.item_gallery_notice,container,false)
        val notice = list[position]

        view.setOnClickListener{
            Toast.makeText(container.context,"这是第$position 个",Toast.LENGTH_SHORT).show()
        }
        view.tag = position
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as View?);
    }



}