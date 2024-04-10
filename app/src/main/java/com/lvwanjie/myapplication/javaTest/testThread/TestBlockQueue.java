package com.lvwanjie.myapplication.javaTest.testThread;

import com.lvwanjie.myapplication.R;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.locks.ReentrantLock;

public class TestBlockQueue {

    public static void main(String[] args){
        testSyncQueue();
        System.out.println("");
    }

    public static void testSyncQueue(){
        System.out.println("estSyncQueue");
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start put");
                try {
                    synchronousQueue.put("a");
                    System.out.println("pub b");
                    synchronousQueue.put("b");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("end put");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start take");
                String s = "";
                try {
                    Thread.sleep(1000);
                    s =  synchronousQueue.take();
                    System.out.println("take s"+s);
                    String s1 =  synchronousQueue.take();
                    System.out.println("take s1"+s1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("end take" + s);
            }
        }).start();

    }
}
