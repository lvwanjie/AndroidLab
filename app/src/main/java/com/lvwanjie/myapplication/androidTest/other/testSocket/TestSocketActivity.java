package com.lvwanjie.myapplication.androidTest.other.testSocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.lvwanjie.myapplication.R;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 测试的同一个app
 */
public class TestSocketActivity extends AppCompatActivity {

    private Executor mExe =  Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_socket);
    }


    public void connectClick(View view){
        mExe.execute(new Runnable() {
            @Override
            public void run() {
                new GreetingClient().connect();
            }
        });
    }

    public void serverCreate(View view){
        int port = 6099;
        try {
            Thread t = new GreetingServer(port);
            t.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}