package com.hengchang.kotlintest;

import android.os.Build;

import androidx.annotation.NonNull;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class TestJava {

    /**
     * << 左移，int 类型移动到 31位 就是最大负值
     * >> >>>  右移 移动后右边空缺>> 补符号位 ，>>> 补0
     * @param args
     */


    static String str ;

    public static void main(String[] args){
//        testIterable();
        if(str != null){
            str.trim();
        }
        System.out.println(str+"");
    }

    public static void testWy(){
        int n = 1;
        int m = (n << 31);
        System.out.println(m);
        int i = -7;
        int j = (i >> 2);
        System.out.println(j);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }


    public static void testIterable(){
        MyIterable myIterable  = new MyIterable();
        for(String o:myIterable){
            System.out.println(o);
        }

//        MyIterator  myIterator = new MyIterator();

    }



    public static class MyIterable implements Iterable<String>{

        @NonNull
        @Override
        public Iterator iterator() {
            System.out.println("iterator");
            return new MyIterator();
        }

        @Override
        public void forEach(@NonNull Consumer action) {
            System.out.println("forEach");

        }

        @NonNull
        @Override
        public Spliterator spliterator() {
            System.out.println("spliterator");
            return Iterable.super.spliterator();
        }
    }

    static class MyIterator implements Iterator<String>{

        String[] s = {"a","b","c"};

        private int curIndex = 0;

        @Override
        public boolean hasNext() {
            if(curIndex < s.length){
                System.out.println("hasNext : "+true );

                return true;
            }
            System.out.println("hasNext : "+false );
            return false;
        }

        @Override
        public String next() {
            System.out.println("next index="+curIndex );
            return s[curIndex ++ ];
        }
    }

}
