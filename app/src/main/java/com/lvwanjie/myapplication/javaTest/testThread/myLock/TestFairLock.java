package com.lvwanjie.myapplication.javaTest.testThread.myLock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestFairLock {

    public static void main(String args[]){
        test();
    }

    static Lock lock = new ReentrantLock(true);
    public static void test(){
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2; j++) {
                    System.out.println("get：" + Thread.currentThread()
                            .getName());
                    lock.lock();
                    System.out.println("当前线程：" + Thread.currentThread()
                            .getName());
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
                    lock.unlock();
                }
            }).start();
        }
    }
}





