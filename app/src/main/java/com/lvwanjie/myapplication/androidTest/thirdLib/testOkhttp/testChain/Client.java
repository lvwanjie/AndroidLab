package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String args[]){
        List<Interceptor> list = new ArrayList<>();
        list.add(new A_Interceptor());
        list.add(new B_Interceptor());
        list.add(new C_Interceptor());
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(list,0);
        String res = realInterceptorChain.proceed();
        System.out.println(res);
    }
}
