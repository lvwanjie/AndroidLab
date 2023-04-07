package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleP {

    private int p;
    private String s;

    public ModuleP(int p,String s){
        this.p = p;
        this.s = s;
    }

    @Provides
    int provideP(){
        return p;
    }

    @Provides
    @Named("i")
    int provideI(){
        return p+1;
    }

    @Provides
    @Named("j")
    int provideJ(){
        return p-1;
    }


    @Provides
    String provideS(){
        return s;
    }

    @Provides
    A provideClassA(){
      return new A();
    }

    @Provides
    B provideClassB(A a){
        return new B(a);
    }
}
