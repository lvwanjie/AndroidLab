package com.lvwanjie.myapplication.androidTest.anim.wheelText;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;
import com.lvwanjie.myapplication.R;

//import net.ellerton.japng.android.api.PngAndroid;

public class TestApngActivity extends AppCompatActivity {

    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_apng);
        iv = findViewById(R.id.image_view);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                a();
            }
        },500);
    }


    public void a(){
        try {
//            Drawable drawable = PngAndroid.readDrawable(this, R.mipmap.heng2);
//            iv.setImageDrawable(drawable);
//            if (drawable instanceof AnimationDrawable) {
//                ((AnimationDrawable)drawable).start();
//            }
        }catch (Exception e){

        }

    }

    public void btClick(View view){
        LottieAnimationView animationView = (LottieAnimationView) findViewById(R.id.animationView);
        animationView.setAnimation("aaa.json");
        animationView.setRepeatCount(3);
//        animationView.set
        boolean bi = animationView.isHardwareAccelerated();
        animationView.playAnimation();
    }
}