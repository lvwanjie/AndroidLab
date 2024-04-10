package com.hengchang.testeventbus3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EventBus.getDefault().register(this);

    }

    @Subscribe
    public void testA(Message message){
        Log.i("TAG", "testA: ");
        EventBus.getDefault().post(new Message());
    }

    @Subscribe
    public void testB(Message message){
        Log.i("TAG", "testB: ");
    }

    public static class Message {

        public int type;
    }
}