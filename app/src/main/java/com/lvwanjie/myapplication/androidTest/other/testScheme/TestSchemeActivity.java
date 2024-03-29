package com.lvwanjie.myapplication.androidTest.other.testScheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;

import com.lvwanjie.myapplication.R;

public class TestSchemeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_scheme);
    }

    public void btClick(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("lab://com.lvwanjie.lab/path?param1=abc&param2=cde"));
        startActivity(intent);
    }
    public void btClick2(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("hxh://com.puhui.hyj/main?pageName=mall"));
        startActivity(intent);
    }

    public void btClick3(View view){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        CountDownTimer countDownTimer;
        intent.setData(Uri.parse("https://anlan-aquarius-client-h5-test.cn-anlan.com/cashier/index?orderNo=963110814817202176840700005&state=START"));
        startActivity(intent);
    }
}