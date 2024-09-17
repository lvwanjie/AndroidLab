package com.lvwanjie.myapplication.javaTest.testFanxing;

public class Test1 {

    public static void main(String args[]){
        A a = new B();
        a.setValue("1");
        a.setValue(11);

        C c = new D();
        c.setValue("1");
//        c.setValue(11);

        E e = new F();
        e.setValue("abc");
    }

    public static class A{
        public void setValue(Object o){
            System.out.println("object");
        }
    }

    public static class B extends A{
        public void setValue(String s){
            System.out.println("String");
        }
    }

    public static class C{
        public void setValue(String o){
            System.out.println("string");
        }
    }

    public static class D extends C{
        public void setValue(Object s){
            System.out.println("object");
        }
    }


    public static class E{
        public void setValue(String o){
            System.out.println("str E");
        }
    }

    public static class F extends E{
        public void setValue(String s){
            System.out.println("str F");
        }
    }
}
