package com.lvwanjie.myapplication.androidTest.widget.testViewStub;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyCustomView extends FrameLayout {
    public MyCustomView(@NonNull Context context) {
        super(context);
    }

    public MyCustomView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        String i = null;
        i.startsWith("");
    }
}
