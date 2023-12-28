package com.lvwanjie.myapplication.javaTest.testFanxing;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;

class Test {
    HttpServlet h;

    static class Fruit{}

    static class Apple extends Fruit{}

    static class RedApple extends Apple{}

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
        A<? super Apple> a = new A();
        a.add(new RedApple());
    }

    public static class A<T>{
        T t;

        public void add(T t){
            this.t = t;
        }

        public T get(){
            return t;
        }
    }

    public void show(A<Apple> a){

        List<? extends Fruit> list = new ArrayList<Apple>();
        Fruit fruit = list.get(0);

    }

    public <T> void getM(T t){

    }

    public void testShow(){
        A<Apple> a = new A<Apple>();
        new Test().show(a);
    }

    private static interface I{
        void i();
    }

    public static class B<E,T> extends A<T> implements I{

        @Override
        public void add(T t) {
            super.add(t);
        }

        @Override
        public void i() {

        }
    }


}
