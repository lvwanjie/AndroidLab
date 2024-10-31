package com.lvwanjie.myapplication.androidTest.testWebView

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lvwanjie.myapplication.R
import com.tencent.smtt.export.external.interfaces.WebResourceError
import com.tencent.smtt.export.external.interfaces.WebResourceRequest
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

class TestWebViewActivity : AppCompatActivity() {
    private val webView: WebView by lazy { findViewById(R.id.webview) }
    companion object{
        const val TAG = "TestWebViewActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_web_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = object: WebViewClient() {
            override fun onPageFinished(p0: WebView?, p1: String?) {
                super.onPageFinished(p0, p1)
                Log.i(TAG, "onPageFinished: ")
            }

            override fun onReceivedError(
                p0: WebView?,
                p1: WebResourceRequest?,
                p2: WebResourceError?
            ) {
                super.onReceivedError(p0, p1, p2)
            }


        }
        webView.loadUrl("https://www.figma.com/")

    }
}