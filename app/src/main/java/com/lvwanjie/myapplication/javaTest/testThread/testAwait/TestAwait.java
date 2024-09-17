package com.lvwanjie.myapplication.javaTest.testThread.testAwait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestAwait {

    public static Lock myLock = new ReentrantLock();
    public static Condition condition1 =  myLock.newCondition();


    public static void main(String args[]){

        MyThread myThreadA = new MyThread("MyThread_A");
        MyThread myThreadB = new MyThread("MyThread_B");
        MyThread myThreadC = new MyThread("MyThread_C");
        MyThread2 myThread2 = new MyThread2("MyThread2");

        myThreadA.start();
        myThreadB.start();
        myThreadC.start();
        myThread2.start();


    }


    public static class MyThread extends Thread{

        public MyThread(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                myLock.lock();
                System.out.println("getLock："+Thread.currentThread().getName());
                sleep(1000);
                condition1.await();
                System.out.println("wait_end："+Thread.currentThread().getName());

            }catch (Exception e){
                e.printStackTrace();
            } finally {
                myLock.unlock();
                System.out.println("unlock："+Thread.currentThread().getName());

            }
        }
    }

    public static  class MyThread2 extends Thread{
        public MyThread2(String name){
            super(name);
        }
        @Override
        public void run() {
            try {
                System.out.println("start:"+Thread.currentThread().getName());
                sleep(5000);
                myLock.lock();
                condition1.signal();
                System.out.println("signal:"+Thread.currentThread().getName());
                sleep(1000);
                condition1.signal();
                System.out.println("signal:"+Thread.currentThread().getName());
                sleep(1000);
                condition1.signal();
                System.out.println("signal:"+Thread.currentThread().getName());
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                myLock.unlock();
                System.out.println("unlock："+Thread.currentThread().getName());
            }
        }
    }
}
