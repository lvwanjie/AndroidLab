package com.lvwanjie.myapplication.androidTest.other.testPath

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.lvwanjie.myapplication.R

class TestPathActivity : AppCompatActivity() {

    private val customView:CustomView by lazy {
        findViewById(R.id.custom_view)
    }
    private val bmiView:BMiProgressView by lazy {
        findViewById(R.id.bmi_view)
    }
    private val editText:EditText by lazy {
        findViewById(R.id.edit_text)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_path)
    }

    fun btClick(view: View){
        val text = editText.text.toString().toIntOrNull()
        if(text is Int && text in 0..100){
            customView.setProgress(text)
            bmiView.setProgress(text)
        }else{
            Toast.makeText(this,"格式错误",Toast.LENGTH_LONG).show();
        }
    }
}