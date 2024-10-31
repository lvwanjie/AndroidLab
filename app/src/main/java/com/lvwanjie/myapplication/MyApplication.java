package com.lvwanjie.myapplication;

import android.app.ActivityManager;
import android.app.Application;
import android.os.Debug;
import android.util.Log;

import com.tencent.mmkv.MMKV;
import com.tencent.smtt.sdk.QbSdk;

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
//        EventBus.builder().addIndex(new ).installDefaultEventBus()

        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                // 内核初始化完成，可能为系统内核，也可能为系统内核
            }

            /**
             * 预初始化结束
             * 由于X5内核体积较大，需要依赖网络动态下发，所以当内核不存在的时候，默认会回调false，此时将会使用系统内核代替
             * @param isX5 是否使用X5内核
             */
            @Override
            public void onViewInitFinished(boolean isX5) {

            }
        });
    }
}
