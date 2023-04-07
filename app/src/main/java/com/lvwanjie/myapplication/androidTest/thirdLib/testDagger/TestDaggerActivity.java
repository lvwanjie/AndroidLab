package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lvwanjie.myapplication.R;

import javax.inject.Inject;


public class TestDaggerActivity extends AppCompatActivity {

    public static final String TAG = "TestDagger";
    @Inject
    A a;

    @Inject
    B b;

//    @Inject
//    C c;

    @Inject
    D d;

    @Inject
    E e;

    @Inject
    UserInfo userInfo1;

    @Inject
    UserInfo userInfo2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_dagger);
//        DaggerMyAppComponent.builder().build().inject(this);
        DaggerMyAppComponent.builder().moduleP(new ModuleP(2,"sss")).build().inject(this);
        Log.i(TAG, "onCreate: "+e.i+";"+e.s+";"+d.i+";"+d.j);
        a.someThingA();
        b.someTingB();
        userInfo1.setAge("111");

    }
}
