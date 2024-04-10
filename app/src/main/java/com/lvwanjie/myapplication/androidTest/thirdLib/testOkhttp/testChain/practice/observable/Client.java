package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.observable;

public class Client {

    public static void main(String args[]){

        Observable observable = new Observable();
        observable.regeist(new Observer.A_Observer());
        observable.notifyData();

    }
}
