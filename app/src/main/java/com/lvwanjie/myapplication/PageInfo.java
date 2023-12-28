package com.lvwanjie.myapplication;

import androidx.annotation.ColorInt;

public class PageInfo {

    public static String pages[] = {
            "com.lvwanjie.myapplication.kotlinTest.TestKotlinActivity",
            "com.lvwanjie.myapplication.androidTest.anim.wheelText.TestApngActivity",
            "com.lvwanjie.myapplication.androidTest.anim.wheelText.RaiseLimitAnimTestActivity",
            "com.lvwanjie.myapplication.androidTest.anim.wheelText.WheelTextActivity",
            "com.lvwanjie.myapplication.androidTest.other.filePath.TestAndroidPathActivity",
            "com.lvwanjie.myapplication.androidTest.other.testScheme.TestSchemeActivity",
            "com.lvwanjie.myapplication.androidTest.other.testH5.TestH5CameraActivity",
            "com.lvwanjie.myapplication.androidTest.other.FileSave.FileSaveActivity",
            "com.lvwanjie.myapplication.androidTest.other.TestDecodeActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestDrawable.TestSaveBitmapActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testWebview.TestWebViewActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testDialog.TestDialogActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestDrawable.TestInsetDrawableActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testDialog.TestFloatWindowActivity",
            "com.lvwanjie.myapplication.androidTest.other.testAnr.TestAnrActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testEventBus.TestEventBusActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testDagger.TestDaggerActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestImageActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testEditText.TestTextChangeActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit.TestRetrofitActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testViewStub.TestViewStubActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestCircleImgActivity",
            "com.lvwanjie.myapplication.androidTest.other.testPath.TestPathActivity",
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
