package com.lvwanjie.myapplication.androidTest.widget.testMerge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.lvwanjie.myapplication.R;


public class MineFunctionCard extends ConstraintLayout {

    public MineFunctionCard(@NonNull Context context) {
        super(context);
        initView();
    }

    public MineFunctionCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public MineFunctionCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView(){
        LayoutInflater.from(getContext()).inflate(R.layout.layout_mine_function_card,this,true);
    }
}
