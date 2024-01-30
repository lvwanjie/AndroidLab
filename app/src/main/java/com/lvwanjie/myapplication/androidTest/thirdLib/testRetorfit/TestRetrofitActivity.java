package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit;

import static com.lvwanjie.myapplication.androidTest.widget.testIntentService.MyIntentService.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
        getData();
    }

    public void getData(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.kuaidi100.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<PostInfo> call = retrofitService.getPostInfo("yuantong","111111");
        call.enqueue(new Callback<PostInfo>() {

            @Override
            public void onResponse(Call<PostInfo> call, Response<PostInfo> response) {
                Log.i(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<PostInfo> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }


    public void btClick2(View view){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.kuaidi100.com/")
                .addConverterFactory(GsonConverterFactory.create()).build();
        RetrofitService retrofitService = retrofit.create(RetrofitService.class);
        Call<PostInfo> call = retrofitService.getPostInfo("yuantong","111111");
        call.enqueue(new Callback<PostInfo>() {

            @Override
            public void onResponse(Call<PostInfo> call, Response<PostInfo> response) {
                Log.i(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<PostInfo> call, Throwable t) {
                Log.i(TAG, "onFailure: ");
            }
        });
    }
}