package com.lvwanjie.myapplication.androidTest.thirdLib.testRetorfit

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.lvwanjie.myapplication.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.coroutines.suspendCoroutine

class TestKtRetrofitActivity : AppCompatActivity() {

    companion object{
        const val URL_200:String = "https://run.mocky.io/v3/974601c5-4381-4ce2-ad09-7edd93ecfe16/"
        const val URL_400:String = "https://run.mocky.io/v3/5b32d122-cff6-43f3-bdac-de7e5e50dec3/"
        const val URL_404:String = "https://run.mocky.io/v3/22ec355f-d4a9-41f9-b9a7-81631198d1e0/"
        const val URL_500:String = "https://run.mocky.io/v3/4f64397b-abe0-493c-8d9d-175838b3b317/"
        const val TAG = "KtRetrofitActivity.kt"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_kt_retrofit)
    }


    fun btClick(view: View){
        getData()
    }

    fun getData(){
        var retrofit = Retrofit.Builder().baseUrl("http://www.myHost.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api = retrofit.create(Api::class.java)
        GlobalScope.launch {

            var response = api.getData("test")
            Log.i("TestKtRetrofitActivity", "btClick: $response")
//            Toast.makeText(this@TestKtRetrofitActivity,"response$response",Toast.LENGTH_SHORT).show()
        }
    }

    fun btClick200(view: View){
        getDataInMock(URL_200)
    }
    fun btClick400(view: View){
        getDataInMock(URL_400)

    }
    fun btClick404(view: View){
        getDataInMock(URL_404)
    }
    fun btClick500(view: View){
        getDataInMock(URL_500)
    }


    private fun getDataInMock(url:String){
        var retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api = retrofit.create(Api::class.java)
        GlobalScope.launch(Dispatchers.Main) {
            runCatching {
                var response = api.getDataInMock()
                Log.i(TAG, "btClick: $response")
                Toast.makeText(this@TestKtRetrofitActivity,"$response",Toast.LENGTH_SHORT).show()
            }.onSuccess {
                Log.i(TAG, "getDataInMock: $it")
            }.onFailure {
                Log.i(TAG, "getDataInMock: ${it.message}")
                it.printStackTrace()
            }

        }
    }


    private fun getDataInCoroutine( url:String){
        var retrofit = Retrofit.Builder().baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var api = retrofit.create(Api::class.java)
        GlobalScope.launch(Dispatchers.Main) {

            suspendCoroutine<Any> {

            }
            runCatching {
                var response = api.getDataInMock()
                Log.i(TAG, "btClick: $response")
                Toast.makeText(this@TestKtRetrofitActivity,"$response",Toast.LENGTH_SHORT).show()
                return@runCatching response
            }.onSuccess {
                Log.i(TAG, "onSuccess: $it")
            }.onFailure {
                Log.i(TAG, "getDataInMock: ${it.message}")
                it.printStackTrace()
            }

        }



    }
    inline fun <reified T> a(t: Class<T>?) {
        val intent = Intent(this, T::class.java)
    }


}