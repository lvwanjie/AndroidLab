package com.lvwanjie.myapplication.androidTest.widget.testLayoutFactory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;

import android.os.Bundle;

import com.lvwanjie.myapplication.R;

public class TestLayoutFactory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutInflaterCompat.setFactory(getLayoutInflater(),new MyLayoutFactory());
        setContentView(R.layout.activity_test_layout_factory);
    }
}