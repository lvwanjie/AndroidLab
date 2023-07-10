package com.lvwanjie.myapplication.javaTest;

import static com.lvwanjie.myapplication.javaTest.Test.*;

import org.apache.http.MethodNotSupportedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public  class Test {

    public Test(){
        System.out.println("A");
    }

    public static void main(String args[]){
//        int x = 1;
//        int y = 2;
//        int z = 3;
//        System.out.println(y+=z--/++x);
        Inner inner = new Inner();
    }


    public static class  Inner extends Test{

        public Inner(){
            System.out.println("B");
        }
    }

}
