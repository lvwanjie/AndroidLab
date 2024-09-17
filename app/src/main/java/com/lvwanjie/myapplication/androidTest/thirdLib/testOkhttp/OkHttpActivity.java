package com.lvwanjie.myapplication.androidTest.thirdLib.testOkhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.lvwanjie.myapplication.R;
import com.lvwanjie.myapplication.androidTest.thirdLib.testDagger.C;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;

public class OkHttpActivity extends AppCompatActivity {

    public static String TAG = "OkHttpActivity.j";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ok_http);
    }

    public void btClick(View view){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().get().url("https://run.mocky.io/v3/d2cce652-0a21-44a5-8889-031eaf2c31a6").build();
        client.interceptors();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i(TAG, "onResponse: "+response.body().string());
            }
        });
    }


    public void testB(){
        OkHttpClient client = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().post(RequestBody.create(MediaType.parse("text/plain"),"")).url("https://run.mocky.io/v3/d2cce652-0a21-44a5-8889-031eaf2c31a6").build();

    }



    public void test() throws IOException {
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new MyRetryInterceptor()).authenticator(new Authenticator() {
            @Override
            public Request authenticate(Route route, Response response) throws IOException {
                return null;
            }
        }).retryOnConnectionFailure(false).build();
        Request request = new Request.Builder().get().url("").build();
        client.interceptors();
        Call call = client.newCall(request);
        call.execute();
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