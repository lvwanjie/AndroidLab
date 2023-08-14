package com.lvwanjie.myapplication.androidTest.other.filePath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.View
import com.lvwanjie.myapplication.R
import java.util.*

class TestAndroidPathActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestAndroidPathActivity";
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_android_path)
    }

    fun btClick(view: View){
        ///data/user/0/com.lvwanjie.myapplication1/cache
        var cacheDir = cacheDir.path
        ///storage/emulated/0/Android/data/com.lvwanjie.myapplication1/cache
        var externalCacheDir = externalCacheDir?.path;
        //[/storage/emulated/0/Android/data/com.lvwanjie.myapplication1/cache]
        var externalCacheDirs = Arrays.toString(externalCacheDirs)

        ///data/user/0/com.lvwanjie.myapplication1/files
        var fileDir = filesDir.path
        ///storage/emulated/0/Android/data/com.lvwanjie.myapplication1/files/Download
        var externalFileDir = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS);
        //[/storage/emulated/0/Android/data/com.lvwanjie.myapplication1/files/Download]
        var externalFileDirs = Arrays.toString(getExternalFilesDirs(Environment.DIRECTORY_DOWNLOADS))
        Log.i(TAG, "path: $cacheDir \n $externalCacheDir \n $externalCacheDirs \n $fileDir \n $externalFileDir \n $externalFileDirs")




    }
}