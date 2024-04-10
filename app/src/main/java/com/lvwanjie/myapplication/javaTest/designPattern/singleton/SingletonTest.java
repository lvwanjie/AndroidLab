package com.lvwanjie.myapplication.javaTest.designPattern.singleton;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.logging.Handler;

public class SingletonTest {


    public static void main(String args[]){
        try {
            Object o = new Object();
            Field field = Handler.class.getDeclaredField("");
            field.setAccessible(true);
            field.get(o);
            field.set(o,new Object());
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
