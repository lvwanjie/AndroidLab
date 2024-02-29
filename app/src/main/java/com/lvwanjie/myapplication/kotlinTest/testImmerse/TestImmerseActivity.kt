package com.lvwanjie.myapplication.kotlinTest.testImmerse

import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.Window
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.annotation.RequiresApi
import androidx.fragment.app.FragmentActivity
import com.lvwanjie.myapplication.R

/**
 *
 * 参考博客https://juejin.cn/post/7203563038301061181
 * 1 当activity 是AppCompatActivity,Theme必须是Theme.Appcompat 的 子类theme
 *
 * android:fitsSystemWindows="true" 设置这个属性的布局 会自动增加paddingTop未状态栏高度
 *  设置了fitsSystemWindows 需要配合fullscreen
 * 沉浸式 1 fullScreen + 2状态栏背景透明 + 3 状态栏文字颜色（8.0以上）
 *
 *
 *
 */

class TestImmerseActivity : FragmentActivity() {

    companion object{
        const val TAG = "TestImmerseActivity.kt"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_immerse)
        transparentStatusBar(window)

    }

    private fun transparentStatusBar(window: Window) {
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

        //SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN 是将activity 的content view 扩展到状态栏
        var systemUiVisibility = window.decorView.systemUiVisibility
        systemUiVisibility =
            systemUiVisibility or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
        window.decorView.systemUiVisibility = systemUiVisibility
//        //状态栏有 默认颜色 黑色或其他色 不设置会覆盖
        window.statusBarColor = Color.TRANSPARENT

        //设置状态栏文字颜色
        setStatusBarTextColor(window, false)

        var statusBarHeight = getStatusBarHeight(this)
        Log.i(TAG, "transparentStatusBar: $statusBarHeight")
    }

    @RequiresApi(Build.VERSION_CODES.R)
    private fun newTransparentStatusBar(window: Window){
        var c = window.decorView.windowInsetsController
        window.setDecorFitsSystemWindows(true)
    }

    private fun setStatusBarTextColor(window: Window, light:Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            var systemUiVisibility = window.decorView.systemUiVisibility
            systemUiVisibility = if (light) { //白色文字
                systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
            } else { //黑色文字
                systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            }
            window.decorView.systemUiVisibility = systemUiVisibility
        }
    }

    fun getStatusBarHeight(context: Context): Int {
        val resId = context.resources.getIdentifier(
            "status_bar_height", "dimen", "android"
        )
        return context.resources.getDimensionPixelSize(resId)
    }



}