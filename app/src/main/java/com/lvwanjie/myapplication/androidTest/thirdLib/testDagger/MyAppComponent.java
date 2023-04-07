package com.lvwanjie.myapplication.androidTest.thirdLib.testDagger;

import android.app.Activity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ModuleP.class)
public interface MyAppComponent {

    void inject(TestDaggerActivity activity);
}
