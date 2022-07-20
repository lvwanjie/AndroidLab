package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lvwanjie.myapplication.R;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class OkHttpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    public void test(){
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new MyRetryInterceptor()).authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                return null;
            }
        }).build();
        Request request = new Request.Builder().get().url("").build();
        client.interceptors();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}