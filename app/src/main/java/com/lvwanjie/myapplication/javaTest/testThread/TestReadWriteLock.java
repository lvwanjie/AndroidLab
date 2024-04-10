package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();


     static ArrayList<String> list = new ArrayList();

    public static void main(String args[]){
        test2();
    }


    /**
     * 读锁加锁后只能读锁共享进入，写锁得等待读锁释放才能进入
     */
    public static void test2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.readLock().lock();
                try {
                    System.out.println("read_start thread = "+Thread.currentThread().getName());

                    Thread.sleep(3000);
                    System.out.println("read_finish thread = "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.readLock().unlock();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.writeLock().lock();
                try {
                    System.out.println("write_start thread = "+Thread.currentThread().getName());

                    Thread.sleep(3000);
                    System.out.println("write_finish thread = "+Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                lock.writeLock().unlock();

            }
        }).start();
    }

    public static void test1(){
        CountDownLatch countDownLatch = new CountDownLatch(3);

        new Thread(new Runnable() {
            @Override
            public void run() {
//                MyTask.writeSomething();
                MyTask.readSomething();
                countDownLatch.countDown();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                MyTask.writeSomething();
                MyTask.readSomething();
                countDownLatch.countDown();

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                MyTask.writeSomething();
                MyTask.readSomething();
                countDownLatch.countDown();

            }
        }).start();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(list.toString());
    }

    public static class MyTask{

        public static void readSomething(){
//            lock.readLock().lock();
            System.out.println("read_ready thread = "+Thread.currentThread().getName());
            list.add("添加数据"+Thread.currentThread().getName());
            lock.writeLock().lock();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("read_finish thread = "+Thread.currentThread().getName());
            lock.writeLock().unlock();

//            lock.readLock().unlock();


        }

        public static void writeSomething(){
            lock.writeLock().lock();
            System.out.println("write_ready thread = "+Thread.currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("write_finish thread = "+Thread.currentThread().getName());
            lock.writeLock().unlock();

        }
    }
}
