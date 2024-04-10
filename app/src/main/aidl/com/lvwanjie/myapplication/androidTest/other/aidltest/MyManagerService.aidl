// MyManagerService.aidl
package com.lvwanjie.myapplication.androidTest.other.aidltest;

// Declare any non-default types here with import statements
import  com.lvwanjie.myapplication.androidTest.other.aidltest.IListener;


interface MyManagerService {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);

    List<String> getBookList();

    void register(IListener listener);

    void register2(IListener listener);
}