package com.lvwanjie.myapplication.androidTest.other.testAnr;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;

public class GenerateAnrService extends Service {

    private int i;

    public static String TAG = "GenerateAnrService";

    private String path ;
    @Override
    public void onCreate() {
        path = getApplicationContext().getFilesDir().getPath();
        Log.i(TAG, "onCreate: ");
        super.onCreate();
//        createBusyThings();
        createIoThings();
    }
    

    public void createBusyThings(){
        while (true){
            Log.i(TAG, "createBusyThings: "+i++);
        }
    }

    public void createIoThings(){

        try {
            while (true){
            long start = System.currentTimeMillis();
            Log.i(TAG, "createIoThings: timeStart" + start);
                File file = new File(path,"anr_things");
                file.createNewFile();
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                int fLength = 0;
                while (fLength < 1024 * 1024 *1024){
                    byte[] b = new byte[1024];
                    fLength += b.length;
                    fileOutputStream.write(b);
                }
                fileOutputStream.close();
                long end = System.currentTimeMillis();
            Log.i(TAG, "createIoThings: timeEnd" + end + "cha="+(end-start));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand: ");
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
