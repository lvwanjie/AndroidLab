package com.lvwanjie.myapplication.javaTest.testStatic;

public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }
    public static final String HELLOWORLD = "hello world!";
}