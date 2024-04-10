package com.lvwanjie.myapplication.javaTest.testThread;

import java.io.IOException;

public class TestRunnable {



    public abstract class SuperTest {

        public abstract void testMethodA() throws BaseException;
        public abstract void testMethodB() throws BaseException;
        public abstract void testMethodC() throws BaseException;
        public abstract void testMethodD() throws BaseException;
        public abstract void testMethodE() throws Exception;
        public abstract void testMethodF() throws IOException;
        public abstract void testMethodG() throws ClassCastException;

    }


    public class Test extends SuperTest {

        public void test(){
            try {
                testMethodE();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            testMethodG();
        }
        @Override
        public void testMethodA() throws BaseException {
            //完全遵循父类方法约束，编译能通过
        }

        @Override
        public void testMethodB() {
            //并没有抛出父类方法的BaseException，编译能通过
        }

        @Override
        public void testMethodC() throws BaseException {
            //此处会报编译错误，父类方法并没有抛出IOException异常
            //'testMethodC()' in 'com.example.Test'
            // clashes with 'testMethodC()' in 'com.example.SuperTest';
            // overridden method does not throw java.io.IOException
        }

        @Override
        public void testMethodD() throws SubException {
            //子类方法抛出的是父类方法抛出的异常类的子类，编译能通过
        }

        @Override
        public void testMethodE() throws IOException {

        }

        @Override
        public void testMethodF() throws IOException {

        }

        @Override
        public void testMethodG() throws ClassCastException {

        }


    }


    public class BaseException extends Exception {

    }


    public class SubException extends BaseException {
    }


}
