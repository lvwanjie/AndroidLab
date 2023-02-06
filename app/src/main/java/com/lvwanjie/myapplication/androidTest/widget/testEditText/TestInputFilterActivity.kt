package com.lvwanjie.myapplication.androidTest.widget.testEditText

import android.os.Bundle
import android.text.*
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R
import com.lvwanjie.myapplication.javaTest.testPattern.FormatCheckUtils


class TestInputFilterActivity : AppCompatActivity() {

    private val editText by lazy {
        findViewById<TextView>(R.id.edit_text)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_input_filter)

        setFilter()
//        setTextListener()
    }

    private fun setFilter(){
        editText.filters = arrayOf(InputFilter { source, start, end, dest, dstart, dend ->
            Log.i("TestInputFilterActivity", "filter: $source;$start;$end;$dest;$dstart;$dend ")
            if(source is String){
                FormatCheckUtils.specialCharRemove(source.toString())
            }else{
                null
            }
        })
    }

    private fun setTextListener(){

        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {}
        })

    }
}