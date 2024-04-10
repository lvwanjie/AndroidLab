package com.lvwanjie.myapplication.androidTest.other.testTouchEvent;

import static com.lvwanjie.myapplication.androidTest.other.testTouchEvent.UtilsKt.getActionStr;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class MyCustomView extends LinearLayout {



    public MyCustomView(Context context) {
        super(context);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "dispatchTouchEvent: "+getActionStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.i(TestTouchEventActivity.TAG, "onInterceptTouchEvent: " + getActionStr(ev.getAction()));
        if(ev.getAction() == MotionEvent.ACTION_MOVE){
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.i(TestTouchEventActivity.TAG, "onTouchEvent: "+getActionStr(event.getAction()));
        return super.onTouchEvent(event);
    }


}
