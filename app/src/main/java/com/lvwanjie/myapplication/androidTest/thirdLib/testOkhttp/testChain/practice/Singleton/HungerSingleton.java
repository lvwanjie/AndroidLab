package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.Singleton;

/**
 *
 */
public class HungerSingleton {

    private static HungerSingleton hungerSingleton = new HungerSingleton();

    private HungerSingleton(){}
    public static HungerSingleton getInstance(){
        return hungerSingleton;
    }
}
