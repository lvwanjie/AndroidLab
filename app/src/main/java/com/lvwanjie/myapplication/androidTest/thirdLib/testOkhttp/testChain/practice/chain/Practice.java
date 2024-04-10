package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链模式  练习
 */
public class Practice {

    public static void main(String args[]){
        List<IInterceptor> list = new ArrayList();
        list.add(new A_Interceptor());
        RealInterceptorChain chain = new RealInterceptorChain(list,0);
        chain.process();
    }
}
