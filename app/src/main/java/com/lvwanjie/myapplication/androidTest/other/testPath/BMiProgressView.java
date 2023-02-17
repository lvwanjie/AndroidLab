package com.lvwanjie.myapplication.androidTest.other.testPath;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.annotation.Nullable;

import com.lvwanjie.myapplication.androidTest.utils.DisplayUtils;

public class BMiProgressView extends View {
    private static final String TAG = "BMiProgressView";
    private int radius = DisplayUtils.dpToPx(67);
    private int ringRadius = DisplayUtils.dpToPx(85);
    private int ringWidth = DisplayUtils.dpToPx(9);
    private int realRingRadius = ringRadius - ringWidth/2;
    private Point centerPoint ;
    private int waveTrans;
    private float percentage ;
    //最大浪高百分比
    private float waveGradient = 0;
    Path circlePath = new Path();
    Paint paint = new Paint();
    Paint bgPaint = new Paint();
    Paint ringPaint = new Paint();
    //单个曲线长度
    private int singleCurveLength = 50;
    //浪高
    private int maxWaveHeight = 10;
    private ObjectAnimator wavePeaceAnim ;
    private Handler handler = new Handler();

    private Runnable delayAnim = new Runnable() {
        @Override
        public void run() {
            wavePeaceAnim = ObjectAnimator.ofFloat(BMiProgressView.this,"waveGradient",waveGradient,0);
            wavePeaceAnim.setDuration(1500);
            wavePeaceAnim.setInterpolator(new AccelerateDecelerateInterpolator());
            wavePeaceAnim.start();
        }
    };


    public BMiProgressView(Context context) {
        super(context);
    }

    public BMiProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        centerPoint = new Point(Math.max(ringRadius,radius),Math.max(ringRadius,radius));
        circlePath.addCircle(centerPoint.x,centerPoint.y,radius, Path.Direction.CW);
        paint.setColor(Color.parseColor("#85e8e1"));
        paint.setStyle(Paint.Style.STROKE);
        bgPaint.setShader(new LinearGradient(0,0,radius,0,
                Color.parseColor("#a4e3eb"),Color.parseColor("#5BACE2"), Shader.TileMode.CLAMP));
        bgPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        ringPaint.setStyle(Paint.Style.STROKE);
        ringPaint.setStrokeWidth(ringWidth);
        ringPaint.setColor(Color.parseColor("#a2e3e9"));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldW, int oldH) {
        super.onSizeChanged(w, h, oldW, oldH);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(centerPoint.x,centerPoint.y,realRingRadius,ringPaint);
        canvas.drawPath(circlePath,bgPaint);
        canvas.clipPath(circlePath);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(getWavePath(percentage),paint);
        if(waveTrans < 2 * singleCurveLength){
            waveTrans ++;
        }else {
            waveTrans = 0;
        }
        invalidate();
    }


    public void setProgress(int p){
        p = Math.max(0,Math.min(100,p));
        float curP = percentage;
        ValueAnimator progressAnim = ObjectAnimator.ofFloat(this,"percentage",curP,p/100f);
        ValueAnimator waveGradientAnim = ObjectAnimator.ofFloat(this,"waveGradient",waveGradient,1);
        progressAnim.setDuration(1000);
        waveGradientAnim.setDuration(1000);
        progressAnim.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet =  new AnimatorSet();
        animatorSet.play(progressAnim).with(waveGradientAnim);
        animatorSet.start();
        handler.removeCallbacks(delayAnim);
        handler.postDelayed(delayAnim,3000);
    }


    //设置浪高度
    private void setWaveGradient(float f){
        Log.i(TAG, "waveGradient: "+f);
        this.waveGradient = f;
    }

    private void setPercentage(float f){
        Log.i(TAG, "setPercentage: "+f);
        this.percentage = f;
    }



    public Path getWavePath(float percentage){
        float verticalLine = radius - percentage*2*radius;
        int y = (int) (centerPoint.y + verticalLine);
        int waveHeight = (int) (waveGradient * maxWaveHeight);

        Path path = new Path();
        //曲线范围要大于圆环
        int startX = centerPoint.x - radius - 2*singleCurveLength + waveTrans;
        int endX = centerPoint.x + radius ;
        path.moveTo(startX,y);
        boolean isUpWave = true;
        int curWaveX = startX;
        while (endX > curWaveX){
            int x1 = curWaveX + singleCurveLength/2;
            int x2 = curWaveX +singleCurveLength;
            curWaveX = x2;
            int waveY;
            if(isUpWave){
              waveY = y + waveHeight;
            }else {
                waveY = y - waveHeight;
            }
            isUpWave = !isUpWave;
            path.quadTo(x1,waveY,x2,y);
        }
        path.lineTo(curWaveX,centerPoint.y+radius);
        path.lineTo(startX,centerPoint.y + radius);

        return path;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Log.i(TAG, "onMeasure: ");
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int withMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(withMode == MeasureSpec.AT_MOST){
            widthSize = Math.max(radius,ringRadius) * 2;
        }
        if(heightMode == MeasureSpec.AT_MOST){
            heightSize = Math.max(radius,ringRadius) * 2;
        }

        setMeasuredDimension(widthSize,heightSize);
    }
}
