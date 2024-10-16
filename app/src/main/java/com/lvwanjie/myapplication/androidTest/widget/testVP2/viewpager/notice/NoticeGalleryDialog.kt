package com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice.gallery.ScalePageTransformer
import com.x2.business.notice.adapter.GalleryPageAdapter

import java.util.Collections

class NoticeGalleryDialog( context: Context) :Dialog(context){

    var list:MutableList<String> = mutableListOf()
    var adapter:GalleryPageAdapter? = null
    var view: View = LayoutInflater.from(context).inflate(R.layout.dialog_notice_gallery,null,false)

    var vpGallery:ViewPager =view.findViewById(R.id.vp_gallery)
    var clContent:View = view.findViewById(R.id.cl_content)


    init {
        setContentView(view)


    }

    fun setNoticeData(data: List<String>){
        this.list.clear()
        this.list.addAll(data)

        //数量大于三个时候第一和第二个交换，首先展示第二个
        val isMore = list.size >=3
        if(isMore){
            Collections.swap(list,0,1);
        }
        adapter = GalleryPageAdapter(list)
        vpGallery.adapter = adapter
        vpGallery.setOffscreenPageLimit(list.size)
        clContent.setOnTouchListener(OnTouchListener { v, event ->
            Log.i("NoticeGalleryDialog", ": ${event.x} ")
            vpGallery.dispatchTouchEvent(event)
        })
        vpGallery.setPageTransformer(false, ScalePageTransformer())
        vpGallery.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            var mIsChanged = false
            var currentIndex  = 0
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {}


            override fun onPageSelected(position: Int) {
                mIsChanged = true
                if (position == 0) {
                    currentIndex = (adapter?.count ?:0) - 2
                } else if (position == (adapter?.count ?:0) - 1) {
                    currentIndex = 1
                } else {
                    currentIndex = position
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {
                    if (mIsChanged) {
                        mIsChanged = false
                        vpGallery.setCurrentItem(currentIndex, false)
                    }
                }
            }
        })


        if(isMore){
            vpGallery.setCurrentItem(1,false)
        }
    }

    override fun show() {
        super.show()
        setDialogSize()
        setCancelable(false)
    }

    private fun setDialogSize(){
        val dialogWindow = window
        val lp = window?.attributes
        dialogWindow!!.setGravity(Gravity.NO_GRAVITY)
        lp?.width = ViewGroup.LayoutParams.MATCH_PARENT
        lp?.height = ViewGroup.LayoutParams.WRAP_CONTENT
        window?.attributes = lp
//        window?.setBackgroundDrawableResource(Color.TRANSPARENT)

    }


}