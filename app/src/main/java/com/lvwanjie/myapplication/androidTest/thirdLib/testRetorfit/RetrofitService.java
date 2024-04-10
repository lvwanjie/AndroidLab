package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface RetrofitService {

    @GET("query")
    Call<PostInfo> getPostInfo(@Query("type") String type,@Query("postid") String postid);

    PostInfo getInfo(@Query("type") String type,@Query("postid") String postid);
}
