package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit

import android.util.Log
import com.lvwanjie.myapplication.androidTest.thirdLib.testDagger.A
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type

class MyConvertFactory: Converter.Factory() {
    
    public companion object{
        const val TAG = "MyConvertFactory.kt";
    }

    override fun requestBodyConverter(
        type: Type,
        parameterAnnotations: Array<out Annotation>,
        methodAnnotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<*, RequestBody>? {
        Log.i(TAG, "requestBodyConverter: $type ;\n $parameterAnnotations ;\n ")
        return super.requestBodyConverter(type, parameterAnnotations, methodAnnotations, retrofit)
    }

    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        Log.i(TAG, "responseBodyConverter: ")
        var v = MyConvert<Response>();
        return v
    }


}

 class MyConvert<T>:Converter<ResponseBody, T>{

    override fun convert(value: ResponseBody): T? {
        var string =  value.string();
        var jsonObject = JSONObject(string)
        var code= jsonObject.optInt("code");
        var message = jsonObject.optString("message")
        var response:Response = Response(code,message)
        Log.i(MyConvertFactory.TAG, "convert:${string} ")
        return response as T;
    }


}

