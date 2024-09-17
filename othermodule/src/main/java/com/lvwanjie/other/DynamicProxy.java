package com.lvwanjie.other;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy {

    public static void main(String args[]){

        LogHandler logHandler = new LogHandler(new Vendor());
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ISell i = (ISell) Proxy.newProxyInstance(ISell.class.getClassLoader(),new Class[]{ISell.class},logHandler);
        i.sell();

    }

    public static class LogHandler implements InvocationHandler {

        public Object target;

        public LogHandler(Object target){
            this.target = target;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(proxy,args);
        }
    }

    public static class Vendor implements ISell{

        @Override
        public void sell() {

        }

        @Override
        public void ad() {

        }

    }

    public interface ISell{

        void sell();

        void ad();
    }

    public void a(){
//        Method method;
//        method.invoke()
    }
}
