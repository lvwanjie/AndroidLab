package com.lvwanjie.myapplication.javaTest.testThread;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFutureTask {

    public static void main(String[] args){
//        testFutureTask();
//        testSubmit();
        testMyFutureTask();
    }


    /**
     * futureTask 可以使用get 获取结果，如果如果任务未结束则等待 如果已经结束则直接获取结果
     */
    public static void testFutureTask(){

        ExecutorService service = Executors.newSingleThreadExecutor();
        FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("start invoke call()");
                Thread.sleep(3000);
                System.out.println("sleep end");
                return "this is call";
            }
        });
        service.execute(futureTask1);
        try {
            Thread.sleep(10000);
            System.out.println("futureTask1 get");
            String res = futureTask1.get(5000, TimeUnit.MILLISECONDS);
            System.out.println("result:"+res);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * submit 会返回一个futuer 对象
     */
    public static void testSubmit(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> f = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("this is call "+Thread.currentThread());
                Thread.sleep(3000);
                return "this is call";
            }
        });
        try {
            System.out.println("this is testSubmit "+Thread.currentThread());
            String s = f.get(5000,TimeUnit.MILLISECONDS);
            System.out.println("result:"+s);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }
    }


    public static void testMyFutureTask(){

        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newSingleThreadExecutor();
        executor.execute(null);

        ExecutorService service = Executors.newSingleThreadExecutor();
        MyFutureTask<String> futureTask1 = new MyFutureTask<>(new Callable<String>(){
            @Override
            public String call() throws Exception {
                System.out.println("start invoke call()");
                Thread.sleep(3000);
                System.out.println("sleep end");
                return "this is call";
            }
        });

        service.execute(futureTask1);
        try {
            String res = futureTask1.get(5000, TimeUnit.MILLISECONDS);
            System.out.println("result: "+res);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
