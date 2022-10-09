package com.merttoptas.interceptorexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.merttoptas.interceptorexample.data.api.ApiClient
import com.merttoptas.interceptorexample.data.model.Everything
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getEverything()
    }

    private fun getEverything() {
        ApiClient.getApiService().getEverythingNews("bitcoin","publishedAt").enqueue(object : Callback<Everything> {
            override fun onResponse(call: Call<Everything>, response: Response<Everything>) {
                Log.d("deneme1", response.body().toString())

                if (response.isSuccessful) {
                    val everything = response.body()
                    everything?.let {
                        Log.d("deneme1", it.articles?.size.toString())
                    }
                }
            }

            override fun onFailure(call: Call<Everything>, t: Throwable) {
                Log.d("deneme1", t.toString())

            }
        })
    }
}