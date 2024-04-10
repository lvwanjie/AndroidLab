package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.Singleton;

public class DCLSingleton {

    private volatile static DCLSingleton mInstance;

    private DCLSingleton(){}

    public static DCLSingleton getInstance(){
        if(mInstance == null){
            synchronized (DCLSingleton.class){
                if(mInstance == null){
                    mInstance = new DCLSingleton();
                }
            }
        }
        return mInstance;
    }


}
