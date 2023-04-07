package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import javax.inject.Inject;

public class C {

    private A a;

    private B b;

    private int c;

    @Inject
    public C(A a, B b){
        this.a = a;
        this.b = b;
    }

    public void doSomethingC(){
        a.someThingA();
        b.someTingB();
    }
}
