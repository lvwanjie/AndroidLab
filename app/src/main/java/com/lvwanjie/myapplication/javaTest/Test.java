package com.lvwanjie.myapplication.javaTest;

import static com.lvwanjie.myapplication.javaTest.Test.*;

import android.net.Uri;

import org.apache.http.MethodNotSupportedException;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public  class Test {

    public Test(){
        System.out.println("A");
    }
    static int i = 1;

    static {
        i = 0;
//        System.out.print(i);
    }


    public static void main(String args[]){
//        int x = 1;
//        int y = 2;
//        int z = 3;
//        System.out.println(y+=z--/++x);
//        Inner inner = new Inner();
                System.out.print("abc"+i);

    }


    public static class  Inner extends Test{

        public Inner(){
            System.out.println("B");
        }
    }

    public static final void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        left --;
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }


    private static void heapSort(int[] arr) {
        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
//            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
//            adjustHeap(arr, 0, i);
        }
    }


}
