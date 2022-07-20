package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.lvwanjie.myapplication.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class TestRetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retorfit);
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.kuaidi100.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call call = retrofitService.getPostInfo("yuantong","111111");
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {

            }

            @Override
            public void onFailure(Call call, Throwable t) {

            }
        });
    }
}