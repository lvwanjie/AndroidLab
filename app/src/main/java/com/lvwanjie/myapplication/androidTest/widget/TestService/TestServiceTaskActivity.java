package com.lvwanjie.myapplication.androidTest.widget.TestService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.widget.testListView.MyAdapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Timer;
import java.util.TimerTask;

public class TestServiceTaskActivity extends AppCompatActivity {

    private TestTaskService testTaskService;

    File originFile;

    private RecyclerView recyclerView;
    private TaskAdapter taskAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_service_task);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        taskAdapter = new TaskAdapter();
        recyclerView.setAdapter(taskAdapter);
        originFile = new File(getExternalCacheDir().getAbsolutePath()+"/testOrigin/a.txt");
        Log.i("TestServiceTaskActivity", "onCreate: "+originFile.getPath());
        generateMyFile();
        Intent intent = new Intent(TestServiceTaskActivity.this, TestTaskService.class);
        startService(intent);
        bindService(intent, serviceConnection, BIND_AUTO_CREATE);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i("GetBinder", "onServiceConnected: "+service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    private void scheduleRefresh(){
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        taskAdapter.notifyDataSetChanged();
                    }
                });
            }
        },500,500);
    }


    public void add(View view){
//        testTaskService.createNewTask(originFile);
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
//        unbindService(serviceConnection);
        super.onDestroy();
    }

    private void generateMyFile(){
        if(originFile.exists() && originFile.length() >1000){
            return;
        }
        try {
            originFile.getParentFile().mkdirs();
            originFile.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(originFile);
            FileChannel fileChannel = fileOutputStream.getChannel();
            fileChannel.write(ByteBuffer.allocate(1), 800*1024*1024);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}