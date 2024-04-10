package com.lvwanjie.myapplication.androidTest.testPlugin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R

class TestClassLoaderActivity : AppCompatActivity() {
    
    companion object{
        const val TAG = "TestClassLoader"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_class_loader_actiivty)

    }

    fun btClick(view: View){
        getInstalledApkPath(this)
    }


    fun getInstalledApkPath(context: Context) {
//        val packageManager = context.packageManager
//        val list = packageManager.queryIntentActivities(Intent(), 0)
//        val activityInfo = list[0].activityInfo
        val packageName = packageName //com.lvwanjie.myapplication
        //apk或jar 目录
        var apkPath = applicationInfo.sourceDir; // /data/app/~~Wun4xjM339t_SA6jZJWRow==/com.lvwanjie.myapplication-9BTSbIBNGEseCG6lKGFDpw==/base.apk
        //dex 解压后的目录
        var dexOutputDir = applicationInfo.dataDir ///data/user/0/com.lvwanjie.myapplication
        //native 代码目录
        var libPath = applicationInfo.nativeLibraryDir ///data/app/~~Wun4xjM339t_SA6jZJWRow==/com.lvwanjie.myapplication-9BTSbIBNGEseCG6lKGFDpw==/lib/arm64
        Log.i(TAG, "getInstalledApkPath: $packageName , $apkPath, $dexOutputDir, $libPath")
    }
}