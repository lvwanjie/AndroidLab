package com.lvwanjie.myapplication.androidTest.testApt;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.os.Bundle;
import android.widget.TextView;

//import com.hengchang.lib.BindView;
import com.lvwanjie.myapplication.R;
import com.lwj.myannotation.MyBindView;

public class TestAptActivity extends AppCompatActivity {

    @MyBindView(R.id.text_view)
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_apt);
    }

    void a(){
        Object o = new Object();
        ObjectAnimator objectAnimator = null;
        objectAnimator.setEvaluator(new TypeEvaluator() {
            @Override
            public Object evaluate(float fraction, Object startValue, Object endValue) {
                return null;
            }
        });
    }


}