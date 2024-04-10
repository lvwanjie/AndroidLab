package com.hengchang.testeventbus3;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MyTest {


    @Subscribe
    public void MyTestFuncA(TMessage message){
        Log.i("TAG", "testA: ");
        EventBus.getDefault().post(new MainActivity.Message());
    }

    @Subscribe
    public void MyTestFuncB(TMessage message){
        Log.i("TAG", "testB: ");
    }

    public static class TMessage {

        public int type;
    }


}
