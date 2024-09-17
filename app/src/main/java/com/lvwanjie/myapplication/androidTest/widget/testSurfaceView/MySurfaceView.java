package com.lvwanjie.myapplication.androidTest.widget.testSurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

//必须实现SurfaceHolder.Callback接口和Runnable接口
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable{

    private SurfaceHolder surfaceHolder;
    private Canvas canvas;
    //子线程绘制标记
    private volatile boolean isDrawing;

    public MySurfaceView(Context context) {
        super(context);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);
        setFocusable(true);
//        setFocusableInTouchMode(true);
//        setKeepScreenOn(true);

    }


    //当SurfaceView被创建的时候被调用
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isDrawing = true;
        new Thread(this).start();
    }

    //当SurfaceView的视图发生改变，比如横竖屏切换时，这个方法被调用
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    //当SurfaceView被销毁的时候，比如不可见了，会被调用
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isDrawing = false;
        surfaceHolder.removeCallback(this);
    }

    @Override
    public void run() {
        while (isDrawing) {
            draw();
        }
    }

    private void draw() {
        try {
            canvas = surfaceHolder.lockCanvas();
            //执行具体的绘制操作

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}

