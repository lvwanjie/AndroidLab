package com.lvwanjie.myapplication.androidTest.other.testHandler;


import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;

public class TestHandler {

    public static void main(String args[]){

    }

    public static void test(){
        Looper.prepare();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

            }
        },1000);

        handler.sendMessage(Message.obtain());
        Looper.loop();
        Looper.myLooper().quit();
        HandlerThread handlerThread;
    }
}
