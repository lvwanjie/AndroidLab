package com.lvwanjie.myapplication.javaTest.testFanxing;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

class Test {
    HttpServlet h;

    static class Fruit{}

    static class Apple extends Fruit{}

    static class Orange extends Fruit{}

    static class LittleApple extends Apple{}

    public static void main(String args[]){
        List<? extends Fruit> list1 = new ArrayList<>();
//        list1.add(new Fruit());
//        list1.add(new Apple());
//        list1.add(new LittleApple());
        Fruit f = list1.get(0);

        List<? super Fruit> list2 = new ArrayList<>();
        list2.add(new Fruit());
        list2.add(new Apple());
        list2.add(new Orange());
        list2.add(new LittleApple());
//        Fruit f2 = list2.get(0);
//        Apple apple2 = list2.get(0);
//        LittleApple littleApple2 = list2.get(0);
    }
}
