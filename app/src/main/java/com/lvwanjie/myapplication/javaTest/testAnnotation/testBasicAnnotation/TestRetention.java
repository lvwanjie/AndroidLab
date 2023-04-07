package com.lvwanjie.myapplication.javaTest.testAnnotation.testBasicAnnotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(value = RetentionPolicy.SOURCE)
public @interface TestRetention {
    String value();
}
