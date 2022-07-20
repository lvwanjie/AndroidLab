package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程池参数
 * 几种阻塞队列
 * 容错机制（超出处理机制）
 * future
 * shutdown shutdownNow
 * reentrantLock
 * await
 */

class TestExecutor {


    public static void main(String args[]){

    }

    public static void testExecutor(){
        Executor executor = new ThreadPoolExecutor(0,3,3000, TimeUnit.SECONDS,null);
    }

    public static void testCacheExecutor(){
        Executors.newCachedThreadPool();
    }

    public static void testSingleExecutor(){
        Executors.newSingleThreadExecutor();
    }

    public static void testFixExecutor(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(0);
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        executor.shutdown();
        executor.shutdownNow();
//        ReentrantLock

    }

    public static void testScheduleExecutor(){
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);
//        executor.schedule()
//        executor.execute();
        Lock lock = new ReentrantLock();
        lock.lock();
    }
}
