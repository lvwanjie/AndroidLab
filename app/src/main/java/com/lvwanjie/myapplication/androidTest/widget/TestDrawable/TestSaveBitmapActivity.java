package com.lvwanjie.myapplication.androidTest.widget.TestDrawable;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.FileUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.lvwanjie.myapplication.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestSaveBitmapActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_save_bitmap);
        imageView = findViewById(R.id.image_view);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},0);
        }
    }

    public void btClick(View view){

       Bitmap bitmap =  screenShot();

       imageView.setImageBitmap(bitmap);
       saveBitmap("test.jpg",bitmap,this);

    }

    public Bitmap screenShot() {
        View view = getWindow().getDecorView();
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();

        return Bitmap.createBitmap(view.getDrawingCache());
    }

    static void saveBitmap(String name, Bitmap bm, Context mContext) {

        Log.d("Save Bitmap", "Ready to save picture");

        //指定我们想要存储文件的地址

        String TargetPath = mContext.getFilesDir() + "/images/";

        Log.d("Save Bitmap", "Save Path=" + TargetPath);

        //判断指定文件夹的路径是否存在

        if (!fileIsExist(TargetPath)) {

            Log.d("Save Bitmap", "TargetPath isn't exist");

        } else {

            //如果指定文件夹创建成功，那么我们则需要进行图片存储操作

            File saveFile = new File(TargetPath, name);

            try {

                FileOutputStream saveImgOut = new FileOutputStream(saveFile);

                // compress - 压缩的意思

                bm.compress(Bitmap.CompressFormat.JPEG, 80, saveImgOut);

                //存储完成后需要清除相关的进程

                saveImgOut.flush();

                saveImgOut.close();

                Log.d("Save Bitmap", "The picture is save to your phone!");

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }

    }

    static boolean fileIsExist(String fileName)

    {

        //传入指定的路径，然后判断路径是否存在

        File file=new File(fileName);

        if (file.exists())

            return true;

        else{

            //file.mkdirs() 创建文件夹的意思

            return file.mkdirs();

        }

    }



}