package com.lvwanjie.myapplication.javaTest.testThread.jt;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 三个线程交替打印
 */

public class TestJiaoTiDaYin3 {

    private Lock lock = new ReentrantLock();
    Condition condition1 =  lock.newCondition();
    Condition condition2 =  lock.newCondition();
    Condition condition3 =  lock.newCondition();

    //第一个是哪个 就在哪个置为true
    private boolean flag = false;

    public static int i = 0;

    public static void main(String args[]){
        TestJiaoTiDaYin3 jiaoti  = new TestJiaoTiDaYin3();
        Thread thread1 = new Thread(jiaoti::task1,"t1");
        Thread thread2 = new Thread(jiaoti::task2,"t2");
        Thread thread3 = new Thread(jiaoti::task3,"t3");
        thread1.start();
        thread2.start();
        thread3.start();
    }


    public void task1(){
        lock.lock();
        while (i< 100){
            condition2.signal();
            System.out.println(i++ + Thread.currentThread().getName());
            try {
                condition1.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        condition2.signalAll();
        System.out.println("task1 unlock");
        lock.unlock();

    }

    public void task2(){
        lock.lock();
        while (i< 100){
            condition3.signal();
            System.out.println(i++ + Thread.currentThread().getName());
            try {
                condition2.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        condition3.signalAll();
        System.out.println("task2 unlock");
        lock.unlock();
    }

    public void task3(){
        lock.lock();
        while (i< 100){
            condition1.signal();
            System.out.println(i++ + Thread.currentThread().getName());
            try {
                condition3.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        condition1.signalAll();
        System.out.println("task3 unlock");
        lock.unlock();
    }
}
