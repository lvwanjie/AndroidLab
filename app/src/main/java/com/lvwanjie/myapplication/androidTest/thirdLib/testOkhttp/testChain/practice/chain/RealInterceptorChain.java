package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.chain;


import java.util.List;

public class RealInterceptorChain implements IInterceptor.Chain {

    private List<IInterceptor> list;
    private int index;

    public RealInterceptorChain(List<IInterceptor> list,int index){
        this.list = list;
        this.index = index;
    }

    @Override
    public void process() {
        if(index >= list.size()){
            return;
        }
        IInterceptor interceptor = list.get(index);
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(list,index-1);
        interceptor.interceptor(realInterceptorChain);

    }

}
