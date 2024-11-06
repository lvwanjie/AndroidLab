package com.lvwanjie.myapplication;

import androidx.annotation.ColorInt;

public class PageInfo {

    public static String pages[] = {
            "com.lvwanjie.myapplication.androidTest.widget.testAudio.TestAudioActivity",
            "com.lvwanjie.myapplication.androidTest.testWebView.TestWebViewActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testSlideDrawer.TestSlideDActivity",
            "com.lvwanjie.myapplication.javaTest.testProgress.TestProgressActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testEditText.adjust.TestAdjustSizeActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.notice.TestVpDialogActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testVP2.viewpager.ViewPagerGalleryActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testVP2.TestCusVp2Activity",
            "com.lvwanjie.myapplication.androidTest.widget.testMerge.TestMergeActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testVP2.TestVp2Activity",
            "com.lvwanjie.myapplication.androidTest.widget.testRecyclerView.testRecyclerAnim.TestRecyclerViewAnimActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestVsyncActivity",
            "com.lvwanjie.myapplication.androidTest.jetpack.testFlow.TestFlowActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.OkHttpActivity",
            "com.lvwanjie.myapplication.androidTest.other.testSocket.TestSocketActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testbitmap.TestBitmapActivity",
            "com.lvwanjie.myapplication.androidTest.testAnim.TestAnimActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testAsyncTask.TestAsyncTaskActivity",
            "com.lvwanjie.myapplication.javaTest.testThread.myLock.TestLockActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testRecyclerView.TestRcMaiDianActivity",
            "com.lvwanjie.myapplication.androidTest.testPlugin.TestClassLoaderActivity",
            "com.lvwanjie.myapplication.kotlinTest.testCoroutines.TestCoroutines2Activity",
            "com.lvwanjie.myapplication.androidTest.widget.testTextView.TestTextViewActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testActivityTransAnim.TestTransAnimActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testFlexBox.TestFlexboxActivity",
            "com.lvwanjie.myapplication.androidTest.other.testmeasure.TestView2Activity",
            "com.lvwanjie.myapplication.androidTest.other.testLife.TestLife1Activity",
            "com.lvwanjie.myapplication.androidTest.other.launchMode.TestLaunchModeActivity",
            "com.lvwanjie.myapplication.androidTest.other.testTouchEvent.TestTouchEventActivity",
            "com.lvwanjie.myapplication.androidTest.other.aidltest.TestAidlActivity",
            "com.lvwanjie.myapplication.androidTest.widget.TestService.TestServiceTaskActivity",
            "com.lvwanjie.myapplication.androidTest.jetpack.TestLiveDataActivity",
            "com.lvwanjie.myapplication.androidTest.widget.testXD.TestXiDingActivity",
            "com.lvwanjie.myapplication.kotlinTest.testImmerse.TestImmerseActivity",
            "com.lvwanjie.myapplication.androidTest.other.testmeasure.TestMeasureActivity",
            "com.lvwanjie.myapplication.kotlinTest.testCoroutines.TestCoroutinesActivity",
            "com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit.TestKtRetrofitActivity",
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
            "com.lvwanjie.myapplication.androidTest.component.testFragment.TestFragmentActivity",
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
