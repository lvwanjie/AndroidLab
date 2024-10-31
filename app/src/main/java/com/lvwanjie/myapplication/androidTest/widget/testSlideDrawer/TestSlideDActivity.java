package com.lvwanjie.myapplication.androidTest.widget.testSlideDrawer;

import static androidx.databinding.DataBindingUtil.setContentView;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.lvwanjie.myapplication.R;

public class TestSlideDActivity extends AppCompatActivity {


    private SlidingDrawer mDrawer;
    private ImageButton imbg;
    private Boolean flag=false;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_slide_drawer2);

        imbg=(ImageButton)findViewById(R.id.handle);
        mDrawer=(SlidingDrawer)findViewById(R.id.slidingdrawer);
        tv=(TextView)findViewById(R.id.tv);

        mDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener()
        {
            @Override
            public void onDrawerOpened() {
                flag=true;
                imbg.setImageResource(android.R.drawable.arrow_down_float);
            }

        });

        mDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener(){

            @Override
            public void onDrawerClosed() {
                flag=false;
                imbg.setImageResource(android.R.drawable.arrow_up_float);
            }

        });

        mDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener(){

            @Override
            public void onScrollEnded() {
                tv.setText("结束拖动");
            }

            @Override
            public void onScrollStarted() {
                tv.setText("开始拖动");
            }

        });


    }
}
