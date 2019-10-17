package com.sam43.mindvalleyimageloaderapplication.services

import com.sam43.mindvalleyimageloaderapplication.model.ResponseImageList
import retrofit2.Call
import retrofit2.http.GET


interface APIService {
    @GET("raw/wgkJgazE")
    fun fetchImageList(): Call<ResponseImageList>
}