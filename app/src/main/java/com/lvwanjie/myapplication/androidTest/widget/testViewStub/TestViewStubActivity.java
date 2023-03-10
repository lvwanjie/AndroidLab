package com.lvwanjie.myapplication.androidTest.widget.testViewStub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;

import com.lvwanjie.myapplication.R;

import java.lang.reflect.InvocationTargetException;

public class TestViewStubActivity extends AppCompatActivity {

    private ViewStub viewStub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_stub);
        viewStub = findViewById(R.id.view_stub);
        View view = viewStub.inflate();

    }
}