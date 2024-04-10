package com.lvwanjie.myapplication.androidTest.widget.testSp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.lvwanjie.myapplication.R;

public class TestSpActivity extends AppCompatActivity {

    private static  final  String TAG = "TestSpActivity.java";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_sp);



//        android.os.FileUtils.setPermissions
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    public void btClickPrivate(View view){

        SharedPreferences spPrivate = getApplicationContext().getSharedPreferences("mode_private",MODE_PRIVATE);
        spPrivate.edit().putString("private_str","my_name").apply();
        spPrivate.edit().putString("private_str","my_name").commit();
        String str = spPrivate.getString("private_str","");
        Log.i(TAG, "btClickPrivate: "+str);

    }
    public void btClickAppend(View view){
        SharedPreferences spPrivate = getSharedPreferences("mode_Append", Context.MODE_APPEND);
        spPrivate.edit().putString("private_str","my_name").apply();
        String str = spPrivate.getString("private_str","");
        Log.i(TAG, "btClickPrivate: "+str);
    }
}