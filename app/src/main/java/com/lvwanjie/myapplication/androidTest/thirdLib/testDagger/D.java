package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import javax.inject.Inject;
import javax.inject.Named;

public class D {

    int i;
    int j;

    @Inject
    public D(@Named("i") int i, @Named("j") int j){
        this.i = i;
        this.j = j;
    }
}
