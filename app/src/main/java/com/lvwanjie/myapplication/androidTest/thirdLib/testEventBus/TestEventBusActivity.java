package com.lvwanjie.myapplication.androidTest.thirdLib.testEventBus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.javaTest.testAnnotation.testCustomAnnotation.Test;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
/**
 * 这里eventBus 并没有生成MyEventBusIndex 类，可能受apt影响（没有定位到原因），单起一个工程是可以生成MyEventBusIndex
 */
public class TestEventBusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event_bus);
        EventBus.getDefault().register(this);
    }

    @Subscribe
    public void testA(Message message){
        Log.i("TAG", "testA: ");
        EventBus.getDefault().post(new Message());
    }

    @Subscribe
    public void testB(){
        Log.i("TAG", "testB: ");
    }


}