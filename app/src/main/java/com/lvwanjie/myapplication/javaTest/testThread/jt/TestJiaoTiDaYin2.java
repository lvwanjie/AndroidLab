package com.lvwanjie.myapplication.javaTest.testThread.jt;

/**
 *  * 线程间交替打印 0-99
 */
public class TestJiaoTiDaYin2 implements Runnable{

    private int i = 0;

    public static void main(String args[]){
        TestJiaoTiDaYin2 jiaoTiDaYin = new TestJiaoTiDaYin2();
        Thread thread1 = new Thread(jiaoTiDaYin);
        Thread thread2 = new Thread(jiaoTiDaYin);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        task();
    }

    public synchronized void task(){
        while (i<100){
            System.out.println((i++)+ "==" + Thread.currentThread().getName());
            notifyAll();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}


