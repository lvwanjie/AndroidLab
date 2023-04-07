package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import javax.inject.Inject;

public class E {

    int i;
    String s;

    @Inject
    public E(int i,String s){
       this.i = i;
       this.s = s;
    }
}
