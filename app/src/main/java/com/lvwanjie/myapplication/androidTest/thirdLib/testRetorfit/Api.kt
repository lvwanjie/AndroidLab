package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit

import com.google.gson.annotations.SerializedName
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("query")
    suspend fun getData(@Query("type")type:String):Response

    @GET(".")
    suspend fun getDataInMock():Response
}



data class Response(
    @SerializedName("code") val code: Int ,
    @SerializedName("message") val message : String
)