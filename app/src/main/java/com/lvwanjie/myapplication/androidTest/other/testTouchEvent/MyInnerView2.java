package com.lvwanjie.myapplication.androidTest.other.testTouchEvent;

import static com.lvwanjie.myapplication.androidTest.other.testTouchEvent.UtilsKt.getActionStr;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyInnerView2 extends LinearLayout {



    public MyInnerView2(Context context) {
        super(context);
    }

    public MyInnerView2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInnerView2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "inner_2_dispatchTouchEvent: "+getActionStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "inner_2_onInterceptTouchEvent: " + getActionStr(ev.getAction()));

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TestTouchEventActivity.TAG, "inner_2_onTouchEvent: "+getActionStr(event.getAction()));
        return true;
    }


}
