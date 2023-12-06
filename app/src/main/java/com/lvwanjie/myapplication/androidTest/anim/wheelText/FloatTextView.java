package com.lvwanjie.myapplication.androidTest.anim.wheelText;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

import com.credithc.common.utils.DeviceUtil;
import com.lvwanjie.myapplication.androidTest.utils.DisplayUtils;

public class FloatTextView extends AppCompatTextView {

    public static String TAG = "FloatTextView.j";
    public FloatTextView(@NonNull Context context) {
        super(context);
    }

    public FloatTextView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setGravity(Gravity.TOP);
    }

    public FloatTextView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setData(String str){
        Log.i(TAG, "setData: "+getTop()+";"+getBottom()+";"+getLeft()+";"+getRight()+";"+getTranslationY()+";"+getScrollY()+";"+getY());
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0,1);
        valueAnimator.setDuration(500);
//        valueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float f = (float) animation.getAnimatedValue();
                int height = DisplayUtils.dpToPx(80);
                setTranslationY(-f * height);
                setAlpha(1-f);
            }
        });
        valueAnimator.start();
    }
}
