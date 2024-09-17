package com.hengchang.testoptimize;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class TestProfileActivity extends AppCompatActivity {

    public static String TAG = "TestProfileActivity.TAG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_profile);
    }

    public void doSomething(View view){
        myFun();
    }

    public void myFun(){
        try {
            Log.i(TAG, "myFun: startSleep");
            Thread.sleep(500);
            Log.i(TAG, "myFun: endSleep");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (i<10000){
            i++;
            Log.i(TAG, "myFun: "+i);
        }
    }
}