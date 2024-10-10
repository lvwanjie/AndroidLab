package com.lvwanjie.myapplication.androidTest.widget.testTextView

import android.os.Bundle
import android.view.View
import android.widget.TextView
//import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lvwanjie.myapplication.R

class TestTextViewActivity : AppCompatActivity() {

    private val textView:SDAdaptiveTextView by lazy {
        findViewById(R.id.text_view)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_test_text_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    public fun btClick(view: View){
        textView.text = "张先生：aaaaaaaaaaaaafafafa"
//        textView.setAdaptiveText("张先生：aaaaaaaaaaaaafafafa")
//        textView.post(Runnable { textView.setAdaptiveText("张先生：aaaaaaaaaaaaafafafa") })
    }


}