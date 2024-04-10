package com.lvwanjie.myapplication.javaTest.testThread.jt;

/**
 * 线程间交替打印 0-99
 */
public class TestJiaoTiDaYin {

    public static int i = 0;
    public static Object o = new Object();

    public static void main(String args[]){

        test2JiaoTi();
    }

    //两个线程交替
    public static void test2JiaoTi(){

        Thread1 thread1 = new Thread1();
        thread1.start();
        Thread2 thread2 = new Thread2();
        thread2.start();
    }

    public synchronized void task(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    static class Thread1 extends Thread{
        @Override
        public void run() {
            synchronized (o){
                while (i<100){
                    System.out.println((i++) + Thread.currentThread().getName());
                    o.notifyAll();
                    try {
                        o.wait();
                        Boolean b = Thread.holdsLock(o);
                        System.out.println("has lock"+b);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }

    static class Thread2 extends Thread{
        @Override
        public void run() {
            synchronized (o){
                while (i<100){
                    System.out.println(i++);
                    o.notifyAll();
                    try {
                        o.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

        }
    }
}
