package com.lvwanjie.myapplication.javaTest.testAnnotation.testBasicAnnotation;

import java.lang.annotation.Documented;

/**
 * javac Test.java TestDocumented.java
 * javadoc -d doc  Test.java TestDocumented.java
 * 生成文档
 */
@Documented
public @interface TestDocumented {
    String value() default "这是Document注解";

}
