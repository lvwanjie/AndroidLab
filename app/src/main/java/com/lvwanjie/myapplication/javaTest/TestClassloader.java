package com.lvwanjie.myapplication.javaTest;

import dalvik.system.DexClassLoader;

class TestClassloader {


    public static void main(String args[]) throws ClassNotFoundException {
        try {
            TestClassloader.class.getClassLoader().loadClass("sl");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        TestClassloader.class.getClassLoader().loadClass("");
        Class.forName("");

        DexClassLoader dexClassLoader = null;
        try {
            Class clz =  dexClassLoader.loadClass("");


        }catch (Exception e){

        }

    }
}
