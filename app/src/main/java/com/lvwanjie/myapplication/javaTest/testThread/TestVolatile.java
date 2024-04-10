package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

public class TestVolatile {
     static  int  a = 0;

    static AtomicInteger atomicInteger = new AtomicInteger(0);

    static Object object = new Object();

    public static void main(String args[]){

        ArrayList arrayList;

        CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                    for(int i=0;i<50000;i++){
                        a++;
                        atomicInteger.incrementAndGet();
                    }
                    latch.countDown();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                    for(int i=0;i<50000;i++){
                        a++;
                        atomicInteger.incrementAndGet();
                    }
                    latch.countDown();


            }
        }).start();

        try {
            latch.await();
            System.out.println("a = "+a);
            System.out.println(" atomicInteger= "+atomicInteger.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public  static void increase(int count){
        synchronized(object){
            for(int i=0;i<count;i++){
                a++;
            }
        }

    }
}
