package com.lvwanjie.myapplication.javaTest.testFanxing;


/**
 * 泛型 pecs(producer extend consumer super)
 * @param <T>
 */
public class MyListT <T>{

    private T t;

    public T get(){
       return t;
    }

    public void set(T t){

    }

    public static void main(String args[]){
        MyListT<? extends Fruit> myListT = new MyListT();
        Fruit apple = myListT.get();
//        myListT.set(new Object()); error
//        myListT.set(Apple);
        MyListT<? super Fruit> myListT1 = new MyListT();
        myListT1.set(new Apple());

       String e =  MyListT.getE("a");
    }


    public static <E> String getE(E e){
        return  "a";
    }

    public static <F> F getF(F f){
        return  f;
    }


    public static class Fruit{}
    public static class Apple extends Fruit {}
    public static class Banana extends Fruit {}
}
