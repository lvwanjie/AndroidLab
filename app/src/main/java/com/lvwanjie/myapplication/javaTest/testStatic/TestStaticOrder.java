package com.lvwanjie.myapplication.javaTest.testStatic;

public class TestStaticOrder {

    /**
     * a的值：谁的代码在上面是谁
     */
    public static int a = 10;

     static {
        a = 11;
    }
//    public static int a = 10;

     public TestStaticOrder(){
         System.out.println(a);
     }

     public static void main(String args[]){
         TestStaticOrder t = new TestStaticOrder();
     }

}
