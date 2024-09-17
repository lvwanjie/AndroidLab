package com.lvwanjie.other.testSocket;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


import com.lvwanjie.other.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * 测试的同一个app
 */
public class TestSocketActivity extends AppCompatActivity {

    private Executor mExe =  Executors.newSingleThreadExecutor();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_socket);
        textView = findViewById(R.id.text);
        EventBus.getDefault().register(this);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageUpdate(MessageInfo messageInfo){
        String curText = textView.getText().toString();
        textView.setText(curText + "\n" +messageInfo.message);
    }
}