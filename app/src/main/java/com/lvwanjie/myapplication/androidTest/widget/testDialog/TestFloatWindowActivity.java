package com.lvwanjie.myapplication.androidTest.widget.testDialog;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.WindowManager.LayoutParams.FIRST_SUB_WINDOW;
import static android.view.WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW;
import static android.view.WindowManager.LayoutParams.LAST_APPLICATION_WINDOW;
import static android.view.WindowManager.LayoutParams.LAST_SUB_WINDOW;
import static android.view.WindowManager.LayoutParams.TYPE_BASE_APPLICATION;
import static android.view.WindowManager.LayoutParams.TYPE_DRAWN_APPLICATION;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.lvwanjie.myapplication.MyApplication;
import com.lvwanjie.myapplication.R;

import java.util.concurrent.ExecutorService;

public class TestFloatWindowActivity extends Activity {

    public static final String TAG = "TestFloatWindowActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_float_window);
        new Handler().post(new Runnable() {
            @Override
            public void run() {
               View view = getWindow().getDecorView();
                Log.i(TAG, "run: ");
            }
        });
    }

    public void btClick(View view){
        dialogShow();
//        wmShow();
    }

    /**
     * dialog 弹窗会有48px 的padding
     * 主要是dialog 里 decorView 里有padding，decorView里的padding 是由mBackgroundPadding设置的
     * 如果想要去除padding
     * 1、dialog.getWindow().getDecorView().setBackground(new ColorDrawable());
     * 2、dialog.getWindow().setBackgroundDrawable(null);  上面的padding 源于window的backgroundDrawable里的padding
     *
     * ps 这里如果只设置dialog.getWindow().getDecorView().setPadding(0,0,0,0)的话，还是会有内边距，原因是因为window有一个
     *  InsetDrawable的背景.使用上面第2种方式可以将background去掉。
     * Q:这里有一个疑问未解开，就是这种内边距会使内容显示不全。正常使用InsetDrawable都是是内容收缩，类似padding。
     *      （精力有限 未往下追，大体推测 是window背景的InsetDrawable 限制了DecorView里绘制空间）
     */
    private void dialogShow(){

        Dialog dialog = new Dialog(this);
        View floatView = LayoutInflater.from(this).inflate(R.layout.layout_float_window,null);
//        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
//        floatView.setLayoutParams(layoutParams);

        dialog.setContentView(floatView);

        WindowManager.LayoutParams  layoutParams = dialog.getWindow().getAttributes();
        layoutParams.width = 1080;
        layoutParams.height = 1080;

//        dialog.getWindow().getDecorView().setBackground(new ColorDrawable());
//        dialog.getWindow().getDecorView().setBackground(new ColorDrawable(Color.parseColor("#7f78c5f2")));
        View mDecorView = dialog.getWindow().getDecorView();
        InsetDrawable colorDrawable = new InsetDrawable(new ColorDrawable(Color.parseColor("#7f78c5f2")),44);
        dialog.getWindow().setBackgroundDrawable(colorDrawable);
        dialog.getWindow().getDecorView().setPadding(0,0,0,0);

//        View myRoot = mDecorView.findViewById(android.R.id.content);
//        if(myRoot != null){
//            myRoot.setPadding(0,0,0,0);
//        }

        dialog.show();
//        dialog.getWindow().getDecorView().invalidate();
//        dialog.getWindow().getDecorView().requestLayout();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                int width = dialog.getWindow().getDecorView().getWidth();
                int height = dialog.getWindow().getDecorView().getHeight();
                int paddingTop = dialog.getWindow().getDecorView().getPaddingTop();
                View decorView = dialog.getWindow().getDecorView();
                View myRoot = decorView.findViewById(R.id.my_root);

                Log.i(TAG, "dialogShow: "+width+";"+height+";"+paddingTop);
            }
        });

    }


    private void dialogShow2(){


    }


    private void wmShow(){
        WindowManager windowManager = (WindowManager)getSystemService(Context.WINDOW_SERVICE);
        View floatView = LayoutInflater.from(this).inflate(R.layout.layout_float_window,null,false);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);
        layoutParams.type = TYPE_BASE_APPLICATION;
        layoutParams.height = 900;
        layoutParams.width = 900;
        windowManager.addView(floatView,layoutParams);

    }
}