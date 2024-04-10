package com.lvwanjie.myapplication;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Debug;
import android.util.Log;

import com.tencent.mmkv.MMKV;

import org.greenrobot.eventbus.EventBus;

public class MyApplication extends Application {
    public static String QD_TAG = "QiDongTag";

    public static MyApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        Debug.startMethodTracing("");
        Log.i(QD_TAG, "Application onCreate: ");

        MMKV.initialize(this);
        try {
//            Thread.sleep(3000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        EventBus.builder().addIndex(new MyEv ).installDefaultEventBus()
    }
}
