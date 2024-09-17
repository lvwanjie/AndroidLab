package com.lvwanjie.myapplication.androidTest.other.testResource

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import com.lvwanjie.myapplication.R

class TestResourceActivity : AppCompatActivity() {

    companion object{
        const val TAG = "TestResourceActivity.k"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_resource)
        resources.getString(R.string.app_name)
        View.inflate(this,R.layout.activity_test_resource,null);
        var view  = findViewById<TextView>(R.id.text_view)
    }

    fun btClick(view:View){
        var c  = baseContext
        var t = this
        Log.i(TAG, "btClick: $c , $t")
    }

    override fun getResources(): Resources {
        var r = super.getResources()
        Log.i(TAG, "getResources: $r")
        return r
    }
}