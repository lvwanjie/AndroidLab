package com.lvwanjie.myapplication.androidTest.anim.wheelText;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class WheelTextVIew extends AppCompatTextView {

    public WheelTextVIew(@NonNull Context context) {
        super(context);
    }

    public WheelTextVIew(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WheelTextVIew(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setText(int oldValue,int value){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(oldValue,value);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
               int value = (int) valueAnimator.getAnimatedValue();
               setText(value+"");
            }
        });
        valueAnimator.start();
    }

}
