package com.lvwanjie.myapplication.javaTest.testAnnotation.testBasicAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(value = ElementType.TYPE)
public @interface TestTarget {
    String value() default "";
    String s();
}
