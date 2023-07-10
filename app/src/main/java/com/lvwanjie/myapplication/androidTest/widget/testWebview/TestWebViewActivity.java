package com.lvwanjie.myapplication.androidTest.widget.testWebview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.lvwanjie.myapplication.R;

public class TestWebViewActivity extends AppCompatActivity {

    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_webview);
        webView = findViewById(R.id.web_view);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);



        webView.loadUrl("https://mail.sina.cn/?vt=4");
    }
}