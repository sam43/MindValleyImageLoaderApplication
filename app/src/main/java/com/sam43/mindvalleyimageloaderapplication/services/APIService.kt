package com.sam43.mindvalleyimageloaderapplication.services

import com.sam43.mindvalleyimageloaderapplication.model.GenericReS
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET


interface APIService {
    @GET("raw/wgkJgazE")
    fun fetchImageListAsync(): Deferred<Response<List<GenericReS>>>
}