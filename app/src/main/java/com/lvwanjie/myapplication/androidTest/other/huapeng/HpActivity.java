package com.lvwanjie.myapplication.androidTest.other.huapeng;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.RemoteViews;

import com.lvwanjie.myapplication.R;

public class HpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    protected void onResume() {
        super.onResume();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            showNotifications();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void showNotifications() {
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default", "test", NotificationManager.IMPORTANCE_DEFAULT);
        notificationManager.createNotificationChannel(channel);
        showNotification1(notificationManager);
        showNotification2(notificationManager);
        showNotification3(notificationManager);
        showNotification4(notificationManager);
//        showGroupSummaryNotification(notificationManager);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showNotification1(NotificationManager notificationManager) {
        showSingleNotification(notificationManager, "title 1", "message 1", 1);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showNotification2(NotificationManager notificationManager) {
        showSingleNotification(notificationManager, "title 2", "message 2", 2);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showNotification3(NotificationManager notificationManager) {
        showSingleNotification(notificationManager, "title 3", "message 3", 3);
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void showNotification4(NotificationManager notificationManager) {
        showSingleNotification(notificationManager, "title 4", "message 4", 4);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    protected void showSingleNotification(NotificationManager notificationManager,
                                          String title,
                                          String message,
                                          int notificationId) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"default");
        builder.setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setGroupSummary(true)

//                .setCustomContentView(getInstallSuccessNotificationCustomView())
                .setLargeIcon(drawable2Bitmap(getDrawable(R.drawable.ic_launcher_background)))
//                                .setCustomContentView(getInstallSuccessNotificationCustomView())

                .setGroup("group");

        Notification notification = builder.build();
        notificationManager.notify(notificationId, notification);
    }

    private void showGroupSummaryNotification(NotificationManager notificationManager) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this,"default");
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setStyle(new NotificationCompat.DecoratedCustomViewStyle())
                .setGroupSummary(true)
//                .setCustomContentView(getInstallSuccessNotificationCustomView())
                .setGroup("group");
        Notification notification = builder.build();
        notificationManager.notify(123456, notification);

    }

    public static Bitmap drawable2Bitmap(Drawable drawable){
        if(drawable == null) {
            return null;
        }
        final Bitmap bmp = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bmp);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return bmp;
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private RemoteViews getInstallSuccessNotificationCustomView() {

        RemoteViews remoteViews = new RemoteViews("com.lvwanjie.myapplication", R.layout.notifition_layout);
        Bitmap appIcon = drawable2Bitmap(getDrawable(R.drawable.ic_launcher_background));
        Bitmap selfIcon = drawable2Bitmap(getDrawable(R.drawable.ic_launcher_background));

        Bitmap icon = mixBitmap(appIcon, selfIcon, 0.59f, 15, 9, PorterDuff.Mode.DST_OUT);
        icon = mixBitmap(icon, selfIcon, 0.53f, 0, 0, PorterDuff.Mode.SRC_OVER);
        remoteViews.setViewVisibility(R.id.icon, View.GONE);
//        remoteViews.setViewVisibility(R.id.icon_miui12, View.VISIBLE);
////        remoteViews.setImageViewBitmap(R.id.icon_miui12, icon);
//
//        remoteViews.setTextViewText(R.id.title, "title");
//        remoteViews.setTextViewText(R.id.body, "body");
//        remoteViews.setViewVisibility(R.id.icon_list, View.GONE);
//        remoteViews.setViewVisibility(R.id.body, View.VISIBLE);
//        remoteViews.setTextViewText(R.id.button, "buttonText");
//        remoteViews.setViewVisibility(R.id.button, View.VISIBLE);

        return remoteViews;
    }



    public static Bitmap mixBitmap(Bitmap bitmap1, Bitmap bitmap2, float dstScale, int rightOutWidth, int bottomOutWidth, PorterDuff.Mode mode) {
        if (bitmap1 == null || bitmap2 == null) {
            return null;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(dstScale, dstScale);
        bitmap2 = Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
        Bitmap resultingImage=Bitmap.createBitmap(bitmap1.getWidth() + rightOutWidth, bitmap1.getHeight() + bottomOutWidth, bitmap1.getConfig());

        Canvas canvas = new Canvas(resultingImage);
        Paint paint = new Paint();
        canvas.drawBitmap(bitmap1, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(mode));
        canvas.drawBitmap(bitmap2, bitmap1.getWidth() - bitmap2.getWidth() + rightOutWidth, bitmap1.getHeight() - bitmap2.getHeight() + bottomOutWidth, paint);
        return resultingImage;
    }

}