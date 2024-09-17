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

//        Handler asyc = new Handler(null,true);
        Message message = new Message();
//        message.setAsynchronous(true);
        handler.sendMessage(Message.obtain());
        Looper.loop();
        Looper.myLooper().quit();
        Looper.myLooper().quitSafely();

        handler.removeCallbacksAndMessages(null);
        handler.removeMessages(0);

        HandlerThread handlerThread = new HandlerThread("");
        Handler handler1 = new Handler(handlerThread.getLooper());
        handler1.post(new Runnable() {
            @Override
            public void run() {

            }
        });
        handlerThread.getLooper();
    }

    public static void testIdle(){
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                //空闲时处理逻辑

                return false;
            }
        });
    }
}
