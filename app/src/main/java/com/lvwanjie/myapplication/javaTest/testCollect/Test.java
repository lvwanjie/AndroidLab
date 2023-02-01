package com.lvwanjie.myapplication.javaTest.testCollect;

import android.util.ArrayMap;
import android.util.LruCache;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

class Test {

    public static void main(String args[]){
        testArrayList();
    }

    public static void testHashmap(){
        HashMap hashMap = new HashMap();
        hashMap.put("","");
        hashMap.remove("");
        hashMap.get("");
    }


    public static void testConHashmap(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("","");
        concurrentHashMap.get("");
    }

    public static void testSparseArray(){
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0,"");
        sparseArray.get(0);
        sparseArray.size();
    }

    public static void testArrayMap(){
        ArrayMap arrayMap = new ArrayMap();
        arrayMap.put("","");
        arrayMap.get("");
    }

    public static void testLinkedHashMap(){
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("","");
        linkedHashMap.get("");
    }

    public static void testLruCache(){
        LruCache lruCache = new LruCache(8){
            @Override
            protected int sizeOf(Object key, Object value) {
                return super.sizeOf(key, value);
            }
        };
        lruCache.put("","");

        lruCache.get("");

        ReadWriteLock readWriteLock;
        CopyOnWriteArrayList copyOnWriteArrayList =new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("");
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(3);
        Lock lock= new ReentrantLock();
        Condition condition =  lock.newCondition();
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testArrayList(){
        ArrayList<String> arrayList = new ArrayList();
        arrayList.add("0");
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");

//        for(int i=0;i<arrayList.size();i++){
//            if(i ==1){
//                arrayList.remove(1);
//            }
//        }

        for(String str:arrayList){
            if("1".equals(str)){
                arrayList.remove(str);
            }
        }
        ThreadPoolExecutor executor;

        Thread.interrupted();
        Thread thread = new Thread();
        thread.isInterrupted();
        thread.interrupt();
    }

    public static void testLinkedList(){
        LinkedList list = new LinkedList();
        list.add("");
        list.get(0);
    }
}
