package com.lvwanjie.myapplication.javaTest.testFanxing;

class MyList<C> {

    private C e;

    public void add(C e){
        MyList<A> myList = my(new MyList<A>());
        int a = myList.e.a;


    }

    public  C get(){
        return e;
    }


    public <T> MyList<T> my(MyList<T> myList){
        return new MyList();
    }


    public class A{
        int a;
    }
}
