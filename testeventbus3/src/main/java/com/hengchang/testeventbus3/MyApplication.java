package com.hengchang.testeventbus3;

import android.app.Application;

import com.lvwanjie.test.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();

    }



}
