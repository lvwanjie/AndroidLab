package com.lvwanjie.myapplication.androidTest.other.testH5;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.PermissionRequest;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

//import com.hxh.shop.authentication.utils.AuthFlowBasicCheckUtil;
//import com.hxh.shop.main.activity.CML_BorrowMoneyActivity;
import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.thirdLib.testDagger.A;
import com.tbruyelle.rxpermissions3.Permission;
import com.tbruyelle.rxpermissions3.RxPermissions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import io.reactivex.rxjava3.functions.Consumer;


public class TestH5CameraActivity extends AppCompatActivity {

    private WebView webView;
    public static String TAG = "TestH5CameraActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_h5_camera);
        webView = findViewById(R.id.webView);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);//允许使用js
        webSettings.setDomStorageEnabled(true);
        webSettings.setSupportMultipleWindows(true);//允许开发多个窗口
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //设置允许JS弹窗

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }

            @SuppressLint("CheckResult")
            @Override
            public void onPermissionRequest(PermissionRequest request) {
                Log.i("TestH5CameraActivity", "onPermissionRequest:ss ");
                String permissions[] = getNaPermissionRequest(request);
                RxPermissions rxPermissions = new RxPermissions(TestH5CameraActivity.this);
//                rxPermissions.request(permissions)
//                        .subscribe(new Consumer<Boolean>() {
//                            @Override
//                            public void accept(Boolean permission) throws Exception {
//                                if(permission){
//                                    request.grant(request.getResources());
//                                }
//                            }
//                        });

            }
        });
//        myWebView.loadUrl(webUrl);
        webView.loadUrl("file:android_asset/index5.html");

    }

    private String[] getNaPermissionRequest(PermissionRequest request){
        String accesses[] = request.getResources();
        List<String> list = new ArrayList();
        for(int i=0;i< accesses.length;i++){
            String access = accesses[i];
            if(TextUtils.equals(access,PermissionRequest.RESOURCE_VIDEO_CAPTURE)){
                list.add(Manifest.permission.CAMERA);
                list.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    public void btClick(View view){
        RxPermissions rxPermissions = new RxPermissions(TestH5CameraActivity.this);
//        rxPermissions.request(Manifest.permission.CAMERA)
//                .subscribe(new Consumer<Boolean>() {
//                    @Override
//                    public void accept(Boolean permission) throws Exception {
//                        if(permission){
//                        }
//                    }
//                });
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i(TAG, "onRequestPermissionsResult: "+ Arrays.toString(permissions));

    }
}