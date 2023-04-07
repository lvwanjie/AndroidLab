package com.lvwanjie.myapplication.javaTest.testAnnotation.testBasicAnnotation;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.reflect.Method;

@TestDocumented
@TestRetention("")
@TestTarget(value = "",s = "")
public class Test{

    public static void main(String args[]){
        TestRetention annotation = Test.class.getAnnotation(TestRetention.class);
        Method[] methods = Test.class.getMethods();

    }
    @TestDocumented
    public String test(){
        return "abc";
    }

}
