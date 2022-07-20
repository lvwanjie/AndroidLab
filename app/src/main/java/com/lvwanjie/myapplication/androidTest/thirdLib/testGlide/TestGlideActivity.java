package com.lvwanjie.myapplication.androidTest.thirdLib.testGlide;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.lvwanjie.myapplication.R;

public class TestGlideActivity extends AppCompatActivity {

    private ImageView imageView1;
    private ImageView imageView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_glide);
        imageView1 = findViewById(R.id.img_1);
        imageView2 = findViewById(R.id.img_2);
        set();
    }


    public void set(){
        String url ="https://img1.baidu.com/it/u=3229045480,3780302107&fm=26&fmt=auto&gp=0.jpg";

        Glide.with(this).load(url).into(imageView1);
    }

    public void setTarget(){
        Glide.with(this).load("").into(new ImageViewTarget<Drawable>(imageView2) {
            @Override
            protected void setResource(@Nullable Drawable resource) {

            }
        });
    }
}