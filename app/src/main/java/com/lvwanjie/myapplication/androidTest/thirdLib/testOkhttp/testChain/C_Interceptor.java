package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

public class C_Interceptor implements Interceptor {

    @Override
    public String interceptor(Chain chain) {
        System.out.println("c_before do something");

        String s = chain.proceed();

        System.out.println("c_after do something");
        return "C"+s;
    }
}
