package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import android.util.Log;

import javax.inject.Inject;

public class B {

    private A a;
//    @Inject
    public B(A a){
        this.a = a;
    }

    public void someTingB(){
        Log.i(TestDaggerActivity.TAG, "someTingB: ");
    }
}
