package com.lvwanjie.myapplication.javaTest.testThread.myLock;

import com.lvwanjie.myapplication.R;

public class MyLockTest {

    static ReentrantLock lock = new ReentrantLock();


    public static void main(String[] args){
        testReentrantLock();
    }

    public static void testReentrantLock(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                myTask();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                myTask();
            }
        }).start();


    }

    public static void myTask(){
        System.out.println(Thread.currentThread());
        lock.lock();
        System.out.println("start do someThing" + Thread.currentThread());
        try {
            Thread.sleep(1000* 5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("end do someThing"+Thread.currentThread());
        lock.unlock();

    }
}
