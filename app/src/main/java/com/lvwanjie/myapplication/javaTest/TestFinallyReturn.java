package com.lvwanjie.myapplication.javaTest;

class TestFinallyReturn {

    public static void main(String args[]){
        System.out.println(testF());
    }

    public static int testF(){
        int i = 0;
        try {
            return i;

        }catch (Exception e){

        }finally {
            i = i+1;
            return i;
        }

    }
}
