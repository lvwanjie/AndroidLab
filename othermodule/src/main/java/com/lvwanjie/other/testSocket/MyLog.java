package com.lvwanjie.other.testSocket;

import android.os.Handler;
import android.os.Looper;

import org.greenrobot.eventbus.EventBus;

public class MyLog {
    private static final String TAG = "TestSocket";
    public static void print(String str){
        android.util.Log.i(TAG, str);
        EventBus.getDefault().post(new MessageInfo(str));
    }
}
