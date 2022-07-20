package com.lvwanjie.myapplication.javaTest.testCollect;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

class MyArrayList<E> implements Iterable{

    public static String TAG = "MyArrayLIst";
    
    private List innerList = new ArrayList();

    public MyArrayList(){
        
    }

    @NonNull
    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer action) {

    }

    public void add(E e){
        innerList.add(e);
    }

    public  class MyIterator<T> implements Iterator {


        private int course = 0;
        @Override
        public boolean hasNext() {
            Log.i(TAG, "hasNext: ");
            return innerList.get(course)!=null;
      }

        @Override
        public Object next() {
            Log.i(TAG, "next: ");
            return null;
        }
    }
}
