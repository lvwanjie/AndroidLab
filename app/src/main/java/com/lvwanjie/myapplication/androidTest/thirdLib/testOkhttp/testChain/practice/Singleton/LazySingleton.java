package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.Singleton;

/**
 * 饿汉模式
 */
public class LazySingleton {

    private static LazySingleton mInstance;

    private LazySingleton(){}

    public static LazySingleton getInstance(){
        if(mInstance == null){
            mInstance = new LazySingleton();
        }
        return mInstance;
    }
}
