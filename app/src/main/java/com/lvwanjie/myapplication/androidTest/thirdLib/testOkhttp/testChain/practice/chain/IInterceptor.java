package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.chain;

public interface IInterceptor {

    String interceptor(Chain chain);


    interface Chain{
        void process();
    }

}
