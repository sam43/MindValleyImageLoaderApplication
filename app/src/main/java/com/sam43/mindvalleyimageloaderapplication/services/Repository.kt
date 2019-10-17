package com.sam43.mindvalleyimageloaderapplication.services

import androidx.lifecycle.LiveData
import com.sam43.mindvalleyimageloaderapplication.model.ResponseImageList
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Repository {
    private var service: APIService

    init {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        val intercept = httpLoggingInterceptor.apply {
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(intercept)
            .build()
        val retrofit = Retrofit.Builder()
            .baseUrl(getBaseUrl())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        service = retrofit.create(APIService::class.java)
    }

    private fun getBaseUrl(): String {
        return "https://pastebin.com/"
    }


    fun fetchAllImageList(): LiveData<ResponseImageList> {
        val apiObject = ApiObject()
        service.fetchImageList().enqueue(apiObject.getApiObject())
        return apiObject.getData()
    }
}