package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.chain;

public class A_Interceptor implements IInterceptor{


    @Override
    public String interceptor(Chain chain) {
        System.out.println("start");
        chain.process();
        System.out.println("end");
        return "A_";
    }
}
