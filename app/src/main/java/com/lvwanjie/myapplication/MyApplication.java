package com.lvwanjie.myapplication;

import android.app.Application;

import com.tencent.mmkv.MMKV;

import org.greenrobot.eventbus.EventBus;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        MMKV.initialize(this);
//        EventBus.builder().addIndex(new ).installDefaultEventBus()
    }
}
