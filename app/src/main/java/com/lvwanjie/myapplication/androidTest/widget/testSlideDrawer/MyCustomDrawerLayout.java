package com.lvwanjie.myapplication.androidTest.widget.testSlideDrawer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lvwanjie.myapplication.R;

public class MyCustomDrawerLayout extends ConstraintLayout {

    private View handlerView;

    public MyCustomDrawerLayout(@NonNull Context context) {
        super(context);
    }

    public MyCustomDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCustomDrawerLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initView(){
//        handlerView = findViewById(R.id.handler);
    }


}
