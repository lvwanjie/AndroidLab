package com.lvwanjie.myapplication.androidTest.widget.TestService;

import android.app.IntentService;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Environment;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.JobIntentService;

import com.lvwanjie.myapplication.MyApplication;

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


public class TestTaskService extends Service {

    private ExecutorService executorService;

    private String downloadPath = MyApplication.mInstance.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath();

    private List<FileState> fileTasks = new ArrayList<>();




    public List<FileState> getFileTasks(){
        return fileTasks;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Binder binder = new Binder();
        Log.i("GetBinder", "onBind: "+binder);
        return binder;
    }

    @Override
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


//    @Override
//    protected void onHandleIntent(@Nullable Intent intent) {
//
//    }

    public void createNewTask(File file){
        FileState fileState = new FileState();
        fileState.saveToSdcard(file,downloadPath);
        fileTasks.add(fileState);

    }

}
