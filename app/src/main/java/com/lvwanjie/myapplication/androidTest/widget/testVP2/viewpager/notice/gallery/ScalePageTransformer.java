package com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice.gallery;

import android.os.Build;
import android.view.View;

import androidx.viewpager.widget.ViewPager;


public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 1.0f;
    public static final float MIN_SCALE = 0.9f;


    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;


        //以圆心进行缩放
        page.setPivotX(page.getWidth() / 2.0f);
        page.setPivotY(page.getHeight() / 2.0f);
        float scale = 1 - 0.433f * Math.abs(position);
        page.setScaleX(scale);
        page.setScaleY(scale);


        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            page.getParent().requestLayout();
        }
    }
}