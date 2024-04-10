package com.lvwanjie.myapplication.androidTest.widget.testbitmap

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R
import kotlin.math.pow

class TestBitmapActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestBitmapActivity.k"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_bitmap)
    }


//    lateinit var bitmap:Bitmap
    /**
     * 测试 逐个创建bitmap
     * 测试结果：每次点击都有明显的攀升
     */
    var list = mutableListOf<Bitmap>()
    fun btCreate(view: View){
        var option = BitmapFactory.Options()
        option.inSampleSize = 1
        var bitmap = BitmapFactory.decodeResource(resources,R.mipmap.bitmap_bg_xxh)

//        option.inBitmap = bitmap
        list.add(bitmap)
    }

    /**
     * 测试回收
     * native 内存明显被回收掉，而且回收后byteCount 为0
     */
    fun btRecycle(view:View){
        for(i in list.indices){
            Log.i(TAG, "before recycle:byteCount =  ${list[i].byteCount} ;allocationByteCount = ${list[i].allocationByteCount}")
            list[i].recycle()
            Log.i(TAG, "after recycle:byteCount =  ${list[i].byteCount} ;allocationByteCount = ${list[i].allocationByteCount}")
        }
    }


    /**
     * 测试 inBitmap
     * 测试结果：内存没有明显的攀升，GC次数变少
     */
    var myBitmap:Bitmap? = null
    var inBitmapList = mutableListOf<Bitmap>()
    fun btTestInBitmap(view: View){
        var option = BitmapFactory.Options()
        option.inBitmap = myBitmap
        option.inMutable = true
        var bitmap = BitmapFactory.decodeResource(resources,R.mipmap.bitmap_bg_xxh,option)
        inBitmapList.add(bitmap)
        myBitmap = bitmap
    }


    fun execSize(view: View){
        execBitmap("xxh")
        execBitmap("xh")
        execBitmap("h")
        execBitmap("m")
    }

    //验证图片计算公式
    //占用内存字节 = 单像素字节 × 图片宽度 × 图片高度 × (设备dpi ÷ 目录dpi)²
    private fun execBitmap(tag:String){
        var res = R.mipmap.bitmap_bg_xxh
        var dirDpi = 480
        when(tag){
            "xxh" -> {
                res = R.mipmap.bitmap_bg_xxh
                dirDpi = 480
            }
            "xh" -> {
                res = R.mipmap.bitmap_bg_xh
                dirDpi = 320
            }
            "h" -> {
                res = R.mipmap.bitmap_bg_h
                dirDpi = 240
            }
            "m" -> {
                res = R.mipmap.bitmap_bg_m
                dirDpi = 120
            }
        }

        // 2338 x 1314 是图片原始的宽高
        // bitmap.width  =  2338 * (设备dpi ÷ 目录dpi)
        var bitmap = BitmapFactory.decodeResource(resources,res)
        var originBitmapSize = bitmap.width * bitmap.height * 4f
        var execBitmapSize = (2338*1314*4) *(Math.pow((getDensity()/dirDpi.toDouble()),2.0))
        Log.i(TAG, "btCreate $tag: \nbyteCount = ${bitmap.byteCount} \nbitmapSize =  $originBitmapSize  \nexec = $execBitmapSize" )
    }



    fun getDensity(): Int{
        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        return dm.densityDpi
    }



}