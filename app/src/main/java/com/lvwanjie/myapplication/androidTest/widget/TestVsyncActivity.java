package com.lvwanjie.myapplication.androidTest.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Choreographer;

import com.google.common.util.concurrent.ServiceManager;
import com.lvwanjie.myapplication.R;

public class TestVsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_vsync);

        Choreographer.getInstance().postFrameCallback(new FPSFrameCallback(System.nanoTime()));
        ClassLoader c = getClassLoader();
        System.out.println("");
    }

    class MyClassLoader extends ClassLoader{
        @Override
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            return super.loadClass(name, resolve);
        }
    }



    public class FPSFrameCallback implements Choreographer.FrameCallback {

        private static final String TAG = "FPS_TEST";
        private long mLastFrameTimeNanos = 0;
        private long mFrameIntervalNanos;

        public FPSFrameCallback(long lastFrameTimeNanos) {
            mLastFrameTimeNanos = lastFrameTimeNanos;
            mFrameIntervalNanos = (long) (1000000000 / 60.0);
        }

        @Override
        public void doFrame(long frameTimeNanos) {

            Log.i(TAG, "doFrame: "+frameTimeNanos);
            //初始化时间
            if (mLastFrameTimeNanos == 0) {
                mLastFrameTimeNanos = frameTimeNanos;
            }
            final long jitterNanos = frameTimeNanos - mLastFrameTimeNanos;
            if (jitterNanos >= mFrameIntervalNanos) {
                final long skippedFrames = jitterNanos / mFrameIntervalNanos;
                if (skippedFrames > 30) {
                    //丢帧30以上打印日志
                    Log.i(TAG, "Skipped " + skippedFrames + " frames!  "
                            + "The application may be doing too much work on its main thread.");
                }
            }
            mLastFrameTimeNanos = frameTimeNanos;
            //注册下一帧回调
            Choreographer.getInstance().postFrameCallback(this);
        }
    }


}