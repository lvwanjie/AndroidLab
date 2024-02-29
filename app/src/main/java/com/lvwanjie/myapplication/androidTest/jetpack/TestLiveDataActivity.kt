package com.lvwanjie.myapplication.androidTest.jetpack

import android.app.job.JobService
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.launch

class TestLiveDataActivity : AppCompatActivity() {

    private var liveData :MutableLiveData<String> = MutableLiveData()
    private val textView:TextView by lazy {
        findViewById(R.id.text_view)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_live_data)
        liveData.observe(this){
             textView.text = it
        }
    }

    fun postValue(view: View){
        lifecycleScope.launch {
            getData()
        }
    }

    private suspend fun getData(){
        liveData.value = "abc"

    }
}