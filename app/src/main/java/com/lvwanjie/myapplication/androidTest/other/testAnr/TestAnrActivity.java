package com.lvwanjie.myapplication.androidTest.other.testAnr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lvwanjie.myapplication.R;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestAnrActivity extends AppCompatActivity {

    private static final  String TAG = "TestAnrActivity";
    private ExecutorService threadPoolExecutor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_anr);
        threadPoolExecutor = Executors.newCachedThreadPool();
    }

    private  long i = 0;

    public void btClick(View view){
        for(int i=0;i<1000;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    print();
                }
            });
        }
    }

    public void mainBusy(View view){
        print();
    }

    private void print(){
        while (true){
            i++;
            Log.i(TAG, "print: "+Thread.currentThread().getName() + ";i="+i);
        }
    }

    private void btClick1(View view){
        Log.i(TAG, "btClick1: "+Thread.currentThread().getName() + ";i="+i);
    }
}