package com.lvwanjie.myapplication.androidTest.widget.testVP2

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.lvwanjie.myapplication.R
import kotlin.math.absoluteValue

class TestVp2Activity : AppCompatActivity() {

    companion object {
        const val TAG = "TestVp2Activity"
    }

    private val viewPage2:ViewPager2 by lazy {
        findViewById(R.id.view_page2)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_vp2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewPage2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPage2.addItemDecoration(object :RecyclerView.ItemDecoration(){

        })

        var recyclerview = viewPage2.getChildAt(0) as RecyclerView
        recyclerview.overScrollMode = View.OVER_SCROLL_NEVER

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(60))
        compositePageTransformer.addTransformer { view, position ->
            val r = 1 - Math.abs(position)
            Log.i(TAG, "$view \ncompositePageTransformer: $position")
            view.scaleY = 0.90f + r * 0.1f
        }

        viewPage2.setPageTransformer(compositePageTransformer)
        viewPage2.offscreenPageLimit = 3

//        viewPage2.setPageTransformer(CompositePageTransformer().apply {
////            addTransformer(ZoomOutPageTransformer())
////            addTransformer(MarginPageTransformer(32))
//            addTransformer(ImageTransformer())
//            addTransformer(Transformer())
//
//        })
        viewPage2.adapter = MyAdapter()
    }

    public fun btClick(view: View){

    }
}

class ImageTransformer: ViewPager2.PageTransformer {

    companion object {
        private const val TAG = "ImageTransformer"
    }

    override fun transformPage(view: View, position: Float) {
        view.visibility = View.VISIBLE
        when {
            position < -2 && position > -3 -> { //左三转左二
                val p = 3 + position
                view.translationX = 1000f - (300f * p)
                view.scaleX = 0.3f + 0.2f * p
                view.scaleY = 0.3f + 0.2f * p
                view.translationZ = 0f
                view.alpha = p
            }
            position < -1 && position >= -2 -> { //左二转左一
                val p = 2 + position // 0 -> 1
                view.translationX = 700f - (400f * p)
                view.scaleX = 0.5f + (0.2f* p)
                view.scaleY = 0.5f + (0.2f * p)
                view.translationZ = 0f + (1f * p)
            }
            position < 0 && position >= -1f -> { //左一转中间
                val p = 1 + position
                view.translationX = 300f - (300f * p)
                view.scaleX = 0.7f + (0.3f * p)
                view.scaleY = 0.7f + (0.3f * p)
                view.translationZ = 1f + (8f * p)
            }
            position >= 0f && position < 1f -> { //右一转中间
                view.translationX = 0 + position * -300
                view.scaleX = 1f - 0.3f * position
                view.scaleY = 1f - 0.3f * position
                view.translationZ = 9 - (8 * position)
            }
            position >= 1f && position < 2f -> { // 右二转右一
                val p = position - 1
                view.translationX = -300 + (p * -400)
                view.scaleX = 0.7f - 0.2f * p
                view.scaleY = 0.7f - 0.2f * p
                view.translationZ = 1 - 1f * p
            }
            position >= 2f && position < 3 -> {  //右3转右2
                val p = position - 2
                view.translationX = -700f + (p * -300f)
                view.scaleX = 0.5f - 0.2f * p
                view.scaleY = 0.5f - 0.2f * p
                view.translationZ = 0f
                view.alpha = 1 - p
            }
            else -> { //左3和右3以外隐藏显示
                view.visibility = View.GONE
            }
        }
    }
}

class Transformer(
    /**
     * 缩放比例
     * 相比于前一item的缩放比例
     */
    private val scale: Float = DEFAULT_SCALE,
    /**
     * item显示总数
     */
    private val count: Int = DEFAULT_COUNT,
    /**
     * 偏移量 要被上层item遮盖的区域v
     */
    private val deviation: Int = DEFAULT_DEVIATION,
): ViewPager2.PageTransformer {

    companion object {
        private const val TAG = "Transformer"

        const val DEFAULT_SCALE = 0.3f
        const val DEFAULT_COUNT = 5
        const val DEFAULT_DEVIATION = 300
    }


    override fun transformPage(page: View, position: Float) {
        Log.d(TAG, "transformPage: x = ${page.translationX}")
        val absPosition = position.absoluteValue
        if (absPosition.toInt() >= count / 2 + 1) {
            page.visibility = View.GONE
            return
        } else {
            page.visibility = View.VISIBLE
        }
        //设置偏移量 拖动过程中动态设置偏移量
        val tran = deviation * position
        Log.d(TAG, "transformPage: tran = $tran")
        page.translationX = -1 * tran
        page.translationZ = count - position.absoluteValue
        //设置缩放比例
        // 拖动过程中动态设置缩放比例在大和小item中顺滑变化
        var s = 1f
        for (i in 1..absPosition.toInt()) {
            s *= (1 - scale)
        }
        val p = absPosition.toInt()
        val tranS = s - (s * scale) * (absPosition - p)
        Log.d(TAG, "transformPage: tranS = $tranS")
        page.scaleX = tranS
        page.scaleY = tranS
        //设置透明度  针对划入显示区域的item设置透明度从0-1
        if (p == count / 2) {
            page.alpha = 1- (absPosition - p)
        }
    }
}



class ZoomOutPageTransformer : ViewPager2.PageTransformer {

    companion object {
        //自由控制缩放比例
        private const val MIN_SCALE_Y = 0.8f //0.85f
    }

    override fun transformPage(page: View, position: Float) {

        Log.i(TestVp2Activity.TAG, "transformPage: $position")
        if (position >= 1 || position <= -1) {
            page.scaleY = MIN_SCALE_Y
        } else if (position < 0) {
            //  -1 < position < 0
            //View 在再从中间往左边移动，或者从左边往中间移动
            val scaleY = MIN_SCALE_Y + (1 + position) * (1 - MIN_SCALE_Y)
            page.scaleY = scaleY
        } else {
            // 0 <= positin < 1
            //View 在从中间往右边移动 或者从右边往中间移动
            val scaleY = (1 - MIN_SCALE_Y) * (1 - position) + MIN_SCALE_Y
            page.scaleY = scaleY
        }
    }
}


class MyAdapter() : RecyclerView.Adapter<MyVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_vp2_item,parent,false)
        return MyVH(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: MyVH, position: Int) {
        holder.bind(position)
    }

}

class MyVH(view: View) :RecyclerView.ViewHolder(view){

    public fun bind(position: Int){
        if(position%2 ==0){
            itemView.setBackgroundColor(Color.parseColor("#000000"))
        }else{
            itemView.setBackgroundColor(Color.parseColor("#F00000"))

        }
    }
}