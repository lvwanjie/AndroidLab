package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import android.util.Log;

import javax.inject.Inject;

public class A {

    public A(){

    }

    public void someThingA(){
        Log.i(TestDaggerActivity.TAG, "someThingA: ");
    }
}
