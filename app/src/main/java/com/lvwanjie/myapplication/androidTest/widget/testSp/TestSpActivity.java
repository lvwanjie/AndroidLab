package com.lvwanjie.myapplication.androidTest.widget.testSp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.lvwanjie.myapplication.R;

public class TestSpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sp);

        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("",MODE_MULTI_PROCESS);
        sharedPreferences.edit().putString("","").commit();


//        android.os.FileUtils.setPermissions
    }
}