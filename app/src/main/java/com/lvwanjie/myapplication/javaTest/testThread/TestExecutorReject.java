package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestExecutorReject {

    public static void main(String args[]){
//        testCallRunPolicy();
        testDiscardOldestPolicy();
    }

    public static void testDiscardOldestPolicy(){
        System.out.println(Thread.currentThread());
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());
        MyTask t1 = new MyTask("id:1");
        MyTask t2 = new MyTask("id:2");
        MyTask t3 = new MyTask("id:3");
        MyTask t4 = new MyTask("id:4");
        MyTask t5 = new MyTask("id:5");
        MyTask t6 = new MyTask("id:6");
        MyTask t7 = new MyTask("id:7");

        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);
        es.execute(t6);
        es.execute(t7);
    }

    public static void testCallRunPolicy(){
        System.out.println(Thread.currentThread());
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0L, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        MyTask t1 = new MyTask("id:1");
        MyTask t2 = new MyTask("id:2");
        MyTask t3 = new MyTask("id:3");
        MyTask t4 = new MyTask("id:4");
        MyTask t5 = new MyTask("id:5");
        MyTask t6 = new MyTask("id:6");
        MyTask t7 = new MyTask("id:7");

        es.execute(t1);
        es.execute(t2);
        es.execute(t3);
        es.execute(t4);
        es.execute(t5);
        es.execute(t6);
        es.execute(t7);

    }

    static  class MyTask implements Runnable {
        private String id;

        public MyTask(String id) {
            this.id = id;
        }

        public void run() {
            try {
                System.out.println(id + Thread.currentThread());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
