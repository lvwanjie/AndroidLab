package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

public interface Interceptor {


    public String interceptor(Chain chain);

    public interface Chain{

        public String proceed();

    }
}
