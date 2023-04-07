package com.lvwanjie.myapplication.javaTest.testAnnotation.testCustomAnnotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String myInfo();
}
