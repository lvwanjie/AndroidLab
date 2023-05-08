package com.lvwanjie.myapplication.androidTest.widget.TestService;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.view.View;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.widget.testListView.MyAdapter;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class TestServiceTaskActivity extends AppCompatActivity {

    private TestTaskService testTaskService;

    File originFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/testOrigin/");

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
        Intent intent = new Intent(this,TestTaskService.class);
        startService(intent);
        bindService(intent,serviceConnection,0);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            testTaskService = (TestTaskService) service;
            taskAdapter.setData(testTaskService.getFileTasks());
            scheduleRefresh();
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
        testTaskService.createNewTask(originFile);
        taskAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        unbindService(serviceConnection);
        super.onDestroy();
    }
}