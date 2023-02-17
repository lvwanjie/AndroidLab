package com.lvwanjie.myapplication.androidTest.utils;

import android.content.res.Resources;

public class DisplayUtils {

    public static int dpToPx(int dpValue) {
        float DENSITY = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * DENSITY + 0.5f);
    }
}
