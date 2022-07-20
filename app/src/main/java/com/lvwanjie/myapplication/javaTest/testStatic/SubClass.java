package com.lvwanjie.myapplication.javaTest.testStatic;


public class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init!");
    }
}