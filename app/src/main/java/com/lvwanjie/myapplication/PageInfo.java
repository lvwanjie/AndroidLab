package com.lvwanjie.myapplication;

import androidx.annotation.ColorInt;

public class PageInfo {

    public static String pages[] = {
            "com.lvwanjie.myapplication.androidTest.widget.testEditText.TestInputFilterActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testIntentService.IntentServiceActivity",
            "com.lvwanjie.myapplication.androidTest.other.huapeng.HpActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testGlide.TestGlideActivity",
            "com.lvwanjie.myapplication.androidTest.component.TestFragmentActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testListView.TestListViewActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testRecyclerView.TestRecyclerViewActivity"
    };

    public PageInfo(String path){
        this.path = path;
        String[] str = path.split("\\.");
        name = str[str.length-1];
        try {
            clz = Class.forName(path);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String name = "";
    public String path ;
    public Class clz;

    @ColorInt
    public int itemColor = -1;
}
