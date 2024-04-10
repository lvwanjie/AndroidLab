package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

public class A_Interceptor implements Interceptor {

    @Override
    public String interceptor(Chain chain) {
        System.out.println("a_before do something");

        String s = chain.proceed();

        System.out.println("a_after do something");

        return "A" +s;
    }
}
