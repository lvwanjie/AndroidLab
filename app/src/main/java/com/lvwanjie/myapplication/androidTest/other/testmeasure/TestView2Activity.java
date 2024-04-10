package com.lvwanjie.myapplication.androidTest.other.testmeasure;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;

import com.lvwanjie.myapplication.R;

public class TestView2Activity extends AppCompatActivity {

    private View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view2);
        view  = findViewById(R.id.view_bg);
//        measureOO();
//        measureM();
//        postGetWH();
        viewTree();

    }

    private void measureOO(){
        view.measure(0,0);
        int w = view.getMeasuredWidth();
        int h = view.getMeasuredHeight();
        Log.i("TestView2Activity.j", "measure00: "+"w="+w+";h="+h); // w=0;h=0
    }

    private void measureM(){
        int withMeasureSpec = View.MeasureSpec.makeMeasureSpec((1<<30)-1,View.MeasureSpec.AT_MOST);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec((1<<30)-1,View.MeasureSpec.AT_MOST);
        view.measure(withMeasureSpec,heightMeasureSpec);
        int w = view.getMeasuredWidth();
        int h = view.getMeasuredHeight();
        Log.i("TestView2Activity.j", "measureM: "+"w="+w+";h="+h); //w=16777215;h=16777215
    }

    private void postGetWH(){
        view.post(new Runnable() {
            @Override
            public void run() {
                int w = view.getMeasuredWidth();
                int h = view.getMeasuredHeight();
                Log.i("TestView2Activity.j", "post: "+"w="+w+";h="+h); // w=1080;h=2159
            }
        });
    }


    private void viewTree(){
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                int w = view.getMeasuredWidth();
                int h = view.getMeasuredHeight();
                Log.i("TestView2Activity.j", "viewTree: "+"w="+w+";h="+h); //w=16777215;h=16777215
            }
        });
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }
}