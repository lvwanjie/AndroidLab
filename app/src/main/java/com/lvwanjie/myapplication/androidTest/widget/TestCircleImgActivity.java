package com.lvwanjie.myapplication.androidTest.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.lvwanjie.myapplication.R;

public class TestCircleImgActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_circle_img);
        imageView = findViewById(R.id.image_view);
        Glide.with(this).load("https://img1.baidu.com/it/u=3027378171,2600015851&fm=253&fmt=auto&app=138&f=JPEG?w=754&h=500")
                .centerCrop()
                .transform(new GlideCircleTransform(this,10,this.getResources().getColor(R.color.white)))
                .into(imageView);

    }
}