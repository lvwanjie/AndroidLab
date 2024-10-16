package com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager.widget.ViewPager
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice.gallery.ScalePageTransformer
import com.x2.business.notice.adapter.GalleryPageAdapter
import java.util.Collections

class TestVpDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_vp_dialog)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setNoticeData(mutableListOf("1","2","3","4","5","6"))
    }


    public fun btClick(view: View){
        val dialog: NoticeGalleryDialog =
            NoticeGalleryDialog(this)

        dialog.setNoticeData(mutableListOf("1","2","3","4","5","6"))
        dialog.show()
        dialog.setOnDismissListener { dialog1 ->

        }
    }

    var list:MutableList<String> = mutableListOf()
    var adapter:GalleryPageAdapter? = null

    val vpGallery:ViewPager  by lazy {findViewById(R.id.vp_gallery)  }
    val clContent:View by lazy { findViewById(R.id.cl_content) }

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
        clContent.setOnTouchListener(View.OnTouchListener { v, event ->
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

}