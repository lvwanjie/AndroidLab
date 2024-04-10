package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain;

import com.lvwanjie.myapplication.R;

import java.util.List;

public class RealInterceptorChain implements Interceptor.Chain{

    private List<Interceptor> interceptors;
    private int index;

    public RealInterceptorChain(List<Interceptor> interceptors,int index){
        this.interceptors = interceptors;
        this.index = index;
    }

    @Override
    public String proceed() {
        if(index >= interceptors.size() ){
            return "";
        }
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(interceptors,index+1);
        Interceptor interceptor = interceptors.get(index);
        String res = interceptor.interceptor(realInterceptorChain);
        return res;
    }
}
