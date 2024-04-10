package com.lvwanjie.myapplication.javaTest.tesetReference;

import com.lvwanjie.myapplication.R;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class TestReference {

    public static void main(String args[]){
        testWeakReference();
    }

    public static void testWeakReference(){
        ReferenceQueue<MyObj> referenceQueue = new ReferenceQueue();
        WeakReference<MyObj> ref = new WeakReference<>(new MyObj("abc"),referenceQueue);
        System.out.println("before GC"+ref);
//        System.gc();
        Runtime.getRuntime().gc();
        try {
            Thread.sleep(1000);
            System.out.println("referenceQueue = "+referenceQueue.poll().get());
            System.out.println("After GC"+ref.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public static void testSoftReference(){
        ReferenceQueue<String> referenceQueue = new ReferenceQueue();
        SoftReference<String> ref = new SoftReference<>("abc",referenceQueue);
        System.out.println("before GC"+ref.get());
        System.out.println("queue get " +referenceQueue.poll());

        System.gc();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("After GC"+ref.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static void testPhantomReference(){
        ReferenceQueue<String> referenceQueue = new ReferenceQueue();
        PhantomReference<String> ref = new PhantomReference<>("abc",referenceQueue);
        System.out.println("before GC"+ref.get());
        System.out.println("queue get " +referenceQueue.poll());

        System.gc();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("After GC"+ref.get());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();
    }

    public static class MyObj{
        public MyObj(String s){
            this.s = s;
        }
        String s = "";
    }
}
