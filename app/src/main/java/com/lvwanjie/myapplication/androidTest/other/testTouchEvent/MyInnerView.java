package com.lvwanjie.myapplication.androidTest.other.testTouchEvent;

import static com.lvwanjie.myapplication.androidTest.other.testTouchEvent.UtilsKt.getActionStr;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyInnerView extends LinearLayout {



    public MyInnerView(Context context) {
        super(context);
    }

    public MyInnerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyInnerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "inner_dispatchTouchEvent: "+getActionStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "inner_onInterceptTouchEvent: " + getActionStr(ev.getAction()));

        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TestTouchEventActivity.TAG, "inner_onTouchEvent: "+getActionStr(event.getAction()));
        return true;
    }


}
