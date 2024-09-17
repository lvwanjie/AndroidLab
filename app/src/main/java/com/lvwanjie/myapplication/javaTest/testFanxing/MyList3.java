package com.lvwanjie.myapplication.javaTest.testFanxing;

import java.util.ArrayList;

public class MyList3<T> {

    T t;

    public void setL(T t){

    }

    public static void main(String args[]){


        // 该子类的泛型T 属于子类 ，和 父类无关联 ，在这设置不影响父类
        MyList3Child<Apple> myList3Child = new MyList3Child();
        myList3Child.setL(new Banana());
//        myList3Child.setC(new Banana());
        myList3Child.setC(new Apple());

        // 该子类的T 和父类T同一个 ，这里设置会影响父类
        MyList3Child2<Apple> myList3Child2 = new MyList3Child2();
//        myList3Child2.setL(new Banana());
        myList3Child2.setL(new Apple());
//        myList3Child2.setC(new Banana());
        myList3Child2.setC(new Apple());
    }

    private <T> void fill(ArrayList<T> numbers) {
    }

    public static class MyList3Child<T extends Fruit> extends MyList3{
        T t;
        public void setC(T t){
           this.t = t;
        }
    }

    public static class MyList3Child2<T extends Fruit> extends MyList3<T>{
        T t;
        public void setC(T t){
            this.t = t;
        }
    }




    public static class Fruit{}
    public static class Apple extends Fruit {}
    public static class Banana extends Fruit {}
}
