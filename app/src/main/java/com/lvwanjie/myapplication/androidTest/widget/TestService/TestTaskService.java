package com.lvwanjie.myapplication.androidTest.widget.TestService;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class TestTaskService extends IntentService {

    private ExecutorService executorService;

    private String downloadPath;

    private List<FileState> fileTasks = new ArrayList<>();


    public TestTaskService(String name) {
        super(name);
        executorService = Executors.newCachedThreadPool();
    }

    public List<FileState> getFileTasks(){
        return fileTasks;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return super.onBind(intent);
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    public void createNewTask(File file){
        FileState fileState = new FileState();
        fileState.saveToSdcard(file,downloadPath);
        fileTasks.add(fileState);

    }

}
