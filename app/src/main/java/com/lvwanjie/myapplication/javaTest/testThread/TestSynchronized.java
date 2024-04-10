package com.lvwanjie.myapplication.javaTest.testThread;

public class TestSynchronized {

    public static void main(String args[]){

        test();

    }

    public static void test(){
        TestSynchronized testSynchronized = new TestSynchronized();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized.task_2();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                testSynchronized.task_2();
            }
        }).start();
    }


    public synchronized static void task(){
        try {
            System.out.println(" start task "+Thread.currentThread());
            Thread.sleep(1000);
            System.out.println(" end task "+Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public  static void task_1(){
        try {
            System.out.println(" start task_1 "+Thread.currentThread());
            Thread.sleep(1000);
            System.out.println(" end task_1 "+Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void task_2(){
        try {
            System.out.println(" start task_2 "+Thread.currentThread());
            Thread.sleep(1000);
            System.out.println(" end task_2 "+Thread.currentThread());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
