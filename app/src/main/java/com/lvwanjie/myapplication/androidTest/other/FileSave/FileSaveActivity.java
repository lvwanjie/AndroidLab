package com.lvwanjie.myapplication.androidTest.other.FileSave;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import com.bumptech.glide.util.Executors;
import com.lvwanjie.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.security.Permission;

public class FileSaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_extr);

    }

    public void getPermission(View view){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},0);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.i("TAG", "onRequestPermissionsResult: ");
    }

    /**
     * Environment.getExternalStorageDirectory().toString() 获取的路径是 /storage/emulated/0
     * 在android31 版本
     * /storage/emulated/0  创建文件提示没有权限
     * 在 /storage/emulated/0/download 路径下 可以创建文件
     * @param view
     */
    public void saveFile(View view){

        try {

            String externalCacheDirPath = getExternalCacheDir().getPath();
            String path = getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath();

            String AppCacheBathPath = Environment.getDownloadCacheDirectory().getPath();
            String AppBathPath = Environment.getExternalStorageDirectory().toString() + File.separator + "download/myTest" + File.separator+"Test.text";


            File file = new File(AppBathPath);
            if(!file.exists()){
                File dir = new File(file.getParent());
                dir.mkdirs();
                file.createNewFile();
            }
            FileOutputStream outStream = new FileOutputStream(file);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}