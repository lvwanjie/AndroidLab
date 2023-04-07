package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import dagger.Module;
import dagger.Provides;

@Module
public class ABParamModule {

    A a;
    B b;

    public ABParamModule(A a,B b){
       this.a = a;
       this.b = b;
    }

//    @Provides
//    public A provideA2(){
//        return a;
//    }

    public B provideB2(){
        return b;
    }
}
