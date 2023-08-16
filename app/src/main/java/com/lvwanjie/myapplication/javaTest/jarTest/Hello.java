package jarTest;

import jarTest.user.Tom;

/**
 *  cd 到 jarTest 目录下
 *  生成class 文件javac Hello.java
 *  生成jar包 jar -cvf hello.jar hello.class
 *  解压jar包 jar xvf /Users/lvwanjie/Desktop/hello.jar
 *
 *  全局生成class文件：sourcePath 需要是package的外层文件夹。例这次package是jarTest，那sourcePath的参数 就需要时他的外层javaTest
 *  javac -verbose -sourcepath javaTest javaTest/jarTest/Hello.java  因为hello.java引用了Tom.java 所以也会编译tom.java
 */
public class Hello {

    public static void main(String args[]){
        System.out.println("hello");
        Tom.speak();
    }
}
