package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

public class B_Interceptor implements Interceptor {

    @Override
    public String interceptor(Chain chain) {
        System.out.println("b_before do something");

        String s = chain.proceed();

        System.out.println("b_after do something");
        return "B"+s;
    }
}
