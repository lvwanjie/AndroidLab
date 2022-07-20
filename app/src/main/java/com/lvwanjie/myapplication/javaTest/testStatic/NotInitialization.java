package com.lvwanjie.myapplication.javaTest.testStatic;


public class NotInitialization {
    public static void main(String[] args) {
//        System.out.println(SubClass.value);
        /**
         * output : SuperClass init!
         *
         * 通过子类引用父类的静态对象不会导致子类的初始化
         * 只有直接定义这个字段的类才会被初始化
         */
//        SuperClass[] sca = new SuperClass[10];
        /**
         * output :
         *
         * 通过数组定义来引用类不会触发此类的初始化
         * 虚拟机在运行时动态创建了一个数组类
         腾讯课堂 Android 高级架构系列免费直播公开课
         https://ke.qq.com/course/341933?flowToken=1017873&taid=5402300059563949&tuin=7e87248a
         更多录播视频+架构学习资料免费领取 QQ 2677509374
         */
        System.out.println(ConstClass.HELLOWORLD);
        /**
         * output :
         *
         * 常量在编译阶段会存入调用类的常量池当中，本质上并没有直接引用到定义类
         常量的类，
         * 因此不会触发定义常量的类的初始化。
         * “hello world” 在编译期常量传播优化时已经存储到 NotInitialization 常量池中
         了。
         */
    }
}