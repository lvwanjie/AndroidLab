package com.hengchang.testoptimize;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.sdk.QbSdk;

import java.util.HashMap;

import leakcanary.AppWatcher;
import leakcanary.LeakCanary;

public class MyApplication extends Application {

    static final String TAG = "MyApplication.j";

    @Override
    public void onCreate() {
        super.onCreate();

        CrashReport.initCrashReport(getApplicationContext(), "7987d69040", true);

        initQBWebView();
        ARouter.init(this);
        AppWatcher.INSTANCE.manualInstall(this);
        Logger.addLogAdapter(new AndroidLogAdapter());
        initSensor();


    }

    private void initSensor(){
        // 初始化配置
        SAConfigOptions saConfigOptions = new SAConfigOptions("");
        // 需要在主线程初始化神策 SDK
        saConfigOptions.enableJavaScriptBridge(true);

        SensorsDataAPI.startWithConfigOptions(this, saConfigOptions);
    }

    private void initQBWebView(){

        QbSdk.initX5Environment(this, new QbSdk.PreInitCallback() {
            @Override
            public void onCoreInitFinished() {
                Log.i(TAG, "onCoreInitFinished: ");
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
        HashMap map = new HashMap();
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_SPEEDY_CLASSLOADER, true);
        map.put(TbsCoreSettings.TBS_SETTINGS_USE_DEXLOADER_SERVICE, true);
        QbSdk.initTbsSettings(map);
    }
}
