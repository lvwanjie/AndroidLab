package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

class MyRetryInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return null;
    }
}
