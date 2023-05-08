package com.lvwanjie.myapplication;

import android.app.Application;

import com.tencent.mmkv.MMKV;

import org.greenrobot.eventbus.EventBus;

public class MyApplication extends Application {

    public static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;

        MMKV.initialize(this);
//        EventBus.builder().addIndex(new ).installDefaultEventBus()
    }
}
