package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.concurrent.SynchronousQueue;

public class EstBlockQueue {

    public static void main(String[] args){
//        estSyncQueue();
        System.out.println("");
    }

    public static void estSyncQueue(){
        SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("start put");
                try {
                    synchronousQueue.put("a");
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
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("end take" + s);
            }
        }).start();

    }
}
