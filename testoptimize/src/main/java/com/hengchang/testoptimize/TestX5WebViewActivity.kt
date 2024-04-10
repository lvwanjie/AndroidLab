package com.hengchang.testoptimize

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tencent.smtt.sdk.WebView

class TestX5WebViewActivity : AppCompatActivity() {

    private lateinit var webView:WebView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_x5_web_view)
        webView = findViewById(R.id.web_view)
        webView.loadUrl("https://www.baidu.com")
    }
}