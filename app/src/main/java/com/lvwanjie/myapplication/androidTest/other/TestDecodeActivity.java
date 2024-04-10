package com.lvwanjie.myapplication.androidTest.other;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.javaTest.TestDecode;

public class TestDecodeActivity extends AppCompatActivity {

    public static String s = "";
    public static String TAG = "TestDecodeActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_decode);
    }

    public void decode(){
        View view = null;
        view.measure(0,0);
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {

            }
        });

        String decodeS = TestDecode.decryptBasedDes(s);
        Log.i(TAG, "decode: "+decodeS);
    }
}