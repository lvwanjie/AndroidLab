package com.lvwanjie.myapplication.javaTest;

class TestClassloader {


    public static void main(String args[]){
        try {
            TestClassloader.class.getClassLoader().loadClass("sl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
