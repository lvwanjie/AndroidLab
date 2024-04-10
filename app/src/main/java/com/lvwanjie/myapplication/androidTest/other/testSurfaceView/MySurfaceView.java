package com.lvwanjie.myapplication.androidTest.other.testSurfaceView;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback,Runnable {

    private SurfaceHolder mHolder;
    private Canvas mCanvas;
    // 子线程标志位
    private boolean mIsDrawing;

    public MySurfaceView(Context context) {
        super(context);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }




    private void initView() {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        //mHolder.setFormat(PixelFormat.OPAQUE);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {

        new Thread(this).start();


    }

    @Override
    public void run() {
        while (mIsDrawing) {
            draw();
        }
    }
    //绘图操作
    private void draw() {
        try {
            mCanvas = mHolder.lockCanvas();
            // draw sth绘制过程
        } catch (Exception e) {
        } finally {
            if (mCanvas != null)
                mHolder.unlockCanvasAndPost(mCanvas);//保证每次都将绘图的内容提交
        }
    }


    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {

    }
}
