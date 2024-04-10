package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp.testChain.practice.observable;

import java.util.ArrayList;
import java.util.List;

public class Observable {

    public List<Observer> list = new ArrayList<>();

    public void regeist(Observer observer){
        list.add(observer);
    }

    public void notifyData(){
        for(Observer observer:list){
            observer.update();
        }
    }
}
