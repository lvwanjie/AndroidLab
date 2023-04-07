package com.lvwanjie.myapplication.androidTest.other.testAnr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lvwanjie.myapplication.R;

public class TestAnrActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anr);
    }

    public void btClick(View view){
        try {
            Thread.sleep(1000*100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}