package com.lvwanjie.myapplication.androidTest.widget.TestService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileState {

    private static ExecutorService executorService = Executors.newCachedThreadPool();

    private float progress = 0;

    public float getProgress(){
        return progress;
    }


    private void saveAsync(File file, String path){
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                saveToSdcard(file,path);
            }
        });
    }

    public void saveToSdcard(File file, String path){
        try {
            InputStream inputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            byte[] buffer = new byte[1024];
            long length = file.length();
            long curLength = 0;
            while (inputStream.read(buffer)!=-1){
                fileOutputStream.write(buffer,0,buffer.length);
                progress= (float)(curLength)/length;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}
