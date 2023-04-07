package com.lvwanjie.myapplication.javaTest.testAnnotation.testCustomAnnotation;

import androidx.annotation.StringDef;

import java.lang.reflect.Method;

@MyAnnotation(myInfo = "abc")
public class Test {

    public static void main(String args[]){
       Test test =  new Test();
       test.TestC();
    }

    public void testM(){
        Test test = new Test();
        try {
            Method[] methods = test.getClass().getDeclaredMethods();
            for(Method method:methods){
                MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
                if(myAnnotation != null){
                    String methodInfo = myAnnotation.myInfo();
                    System.out.println(methodInfo);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void TestC(){
        MyAnnotation myAnnotation = Test.class.getAnnotation(MyAnnotation.class);
        String myInfo = myAnnotation.myInfo();
        System.out.println(myInfo);
    }

    @MyAnnotation(myInfo = "method")
    public void testMethod(){
        String s = "";
        System.out.println(s);
        testDef("a");
    }


    public void testDef(@MyDef String str){

    }


}
