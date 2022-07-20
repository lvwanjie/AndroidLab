package com.lvwanjie.myapplication.androidTest.thirdLib.testMMKV;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lvwanjie.myapplication.R;
import com.tencent.mmkv.MMKV;

public class TestMMKVActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_mmkv);
    }

    public void btClick(){
        MMKV mmkv = MMKV.mmkvWithID("user");
        mmkv.encode("key",1);
    }
}