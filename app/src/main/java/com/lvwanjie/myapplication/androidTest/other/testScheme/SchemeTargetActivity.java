package com.lvwanjie.myapplication.androidTest.other.testScheme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.lvwanjie.myapplication.R;

public class SchemeTargetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheme_target);

        Log.i("SchemeTargetActivity", "onCreate: ");
        getIntent().getData().getQueryParameter("param2");

    }
}