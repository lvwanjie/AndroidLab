package com.lvwanjie.myapplication.javaTest.testThread;

public class testFinallyReturn {

    public static void main(String args[]){

        System.out.println(testA());
        System.out.println(testB());
    }


    public static int testA(){
        int a = 100;
        return a--;
    }

    public static int testB(){
        int a = 100;
        return --a;
    }


    /**
     * try:2
     * finally:3
     * 2
     * @return
     */
    private int testReturn1() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
        } finally {
            i++;
            System.out.println("finally:" + i);
        }
        return i;
    }


    /**
     * try:2
     * finally:3
     * 3
     * @return
     */
    private int testReturn4() {
        int i = 1;
        try {
            i++;
            System.out.println("try:" + i);
            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch:" + i);
            return i;
        } finally {
            i++;
            System.out.println("finally:" + i);
            return i;
        }
    }
}
